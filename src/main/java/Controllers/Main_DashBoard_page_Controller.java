package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class Main_DashBoard_page_Controller {


    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnHistory;

    @FXML
    private Button btnIssueBook;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnReturnBook;

    @FXML
    private Button btnView;
    @FXML
    private Button btnDashboard;

    @FXML
    void btnOnActionAddBook(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Add_Book.fxml "))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.centerOnScreen();
        stage.show();


    }

    @FXML
    void btnOnActionLogOut(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("Logging Out");
        alert.setContentText("Are you sure you want to log out?");
        if(alert.showAndWait().orElse(ButtonType.CANCEL)==ButtonType.OK){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = null;
            try {
                scene = new Scene(FXMLLoader.load(getClass().getResource("/View/LoginPage.fxml")));
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
