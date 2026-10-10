package Controllers;

import Controllers.AddBook.BookController;
import Controllers.AddMember.MemberController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main_DashBoard_page_Controller implements Initializable {

    @FXML private Button btnAddBook;
    @FXML private Button btnAddMember;
    @FXML private Button btnDashboard;
    @FXML private Button btnHistory;
    @FXML private Button btnIssueBook;
    @FXML private Button btnLogOut;
    @FXML private Button btnReturnBook;
    @FXML private Button btnView;
    @FXML private HBox navBarBox;

    @FXML private StackPane contentPane;
    @FXML private AnchorPane dashboardContentPane;

    @FXML private TextField txtBorrowedBooks;
    @FXML private TextField txtOverDueBooks;
    @FXML private TextField txtTotalBooks;
    @FXML private TextField txtTotalMembers;

    private BookController bookController = new BookController();
    private MemberController memberController = new MemberController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDashboardStatistics();
    }

    private void loadDashboardStatistics() {
        if (txtTotalBooks != null) {
            int totalBooks = bookController.getTotalBooksCount();
            int totalMembers = memberController.getTotalMembersCount();

            txtTotalBooks.setText(String.valueOf(totalBooks));
            txtTotalMembers.setText(String.valueOf(totalMembers));
            txtBorrowedBooks.setText("4");
            txtOverDueBooks.setText("1");
        }
    }

    // Updated loadUI method with subfolder fallback protection
    private void loadUI(String fxmlFileName) {
        try {
            // Try loading from root /View/ first, then check common subfolders if null
            URL fileUrl = getClass().getResource("/View/" + fxmlFileName);

            if (fileUrl == null) {
                // Fallback check if it's placed inside a subfolder matching the name
                String folderName = fxmlFileName.replace(".fxml", "");
                fileUrl = getClass().getResource("/View/" + folderName + "/" + fxmlFileName);
            }

            if (fileUrl == null) {
                throw new IOException("FXML file not found: " + fxmlFileName);
            }

            Parent root = FXMLLoader.load(fileUrl);
            contentPane.getChildren().clear();
            contentPane.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Loading Error");
            alert.setHeaderText("Could not load page view");
            alert.setContentText("Failed to locate: " + fxmlFileName + "\nEnsure the FXML file exists in your resources/View folder.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnOnActionDashboard(ActionEvent event) {
        contentPane.getChildren().clear();
        contentPane.getChildren().add(dashboardContentPane);
        loadDashboardStatistics();
    }

    @FXML
    void btnOnActionAddBook(ActionEvent event) {
        loadUI("Add_Book.fxml");
    }

    @FXML
    void btnOnActionAddMember(ActionEvent event) {
        // If your file is inside a subfolder like resources/View/AddMember/Add_Member.fxml,
        // you can also explicitly pass it like: loadUI("AddMember/Add_Member.fxml");
        loadUI("Add_Member_Page.fxml");
    }

    @FXML
    void btnOnActionView(ActionEvent event) {
        // loadUI("View_Books.fxml");
    }

    @FXML
    void btnOnActionIssueBook(ActionEvent event) {
        // loadUI("Issue_Book.fxml");
    }

    @FXML
    void btnOnActionReturnBook(ActionEvent event) {
        // loadUI("Return_Book.fxml");
    }

    @FXML
    void btnOnActionHistory(ActionEvent event) {
        // loadUI("History.fxml");
    }

    @FXML
    void btnOnActionLogOut(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("Logging Out");
        alert.setContentText("Are you sure you want to log out?");

        if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/View/LoginPage.fxml")));
                stage.setScene(scene);
                stage.setTitle("Library Management System - Login");
                stage.setMinWidth(600);
                stage.setMinHeight(450);
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}