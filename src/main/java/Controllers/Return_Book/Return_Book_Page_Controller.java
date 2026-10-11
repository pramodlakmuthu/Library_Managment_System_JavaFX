package Controllers.Return_Book;

import Controllers.Issue_Book.IssueController;
import Model.IssueBook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Return_Book_Page_Controller implements Initializable {

    @FXML private TextField txtSearchIssueId;
    @FXML private TextField txtMemberInfo;
    @FXML private TextField txtBookInfo;
    @FXML private DatePicker dateBorrow;
    @FXML private DatePicker dateDue;
    @FXML private DatePicker dateReturn;
    @FXML private Label lblOverdueStatus;
    @FXML private Button btnReturnBook;

    private ReturnController returnController = new ReturnController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set default return date to today
        dateReturn.setValue(LocalDate.now());

        // Make info fields read-only since they auto-populate from the search
        if (txtMemberInfo != null) txtMemberInfo.setEditable(false);
        if (txtBookInfo != null) txtBookInfo.setEditable(false);
    }

    @FXML
    void btnOnActionSearch(ActionEvent event) {
        String searchId = txtSearchIssueId.getText().trim();

        if (searchId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Warning", "Please enter an Issue ID or Transaction Reference to search.");
            return;
        }

        // TODO: Replace with your actual lookup logic from IssueController/Database
        // For sample demonstration, simulating a found record:
        if (searchId.equals("ISS-001")) {
            txtMemberInfo.setText("M001 - John Doe");
            txtBookInfo.setText("B001 - Java Programming");
            dateBorrow.setValue(LocalDate.now().minusDays(10));
            dateDue.setValue(LocalDate.now().minusDays(3)); // Due 3 days ago (Overdue)

            checkOverdue();
        } else {
            showAlert(Alert.AlertType.ERROR, "Not Found", "No active borrowing record found for ID: " + searchId);
        }
    }

    @FXML
    void dateReturnOnAction(ActionEvent event) {
        checkOverdue();
    }

    private void checkOverdue() {
        if (dateDue.getValue() != null && dateReturn.getValue() != null) {
            LocalDate dueDate = dateDue.getValue();
            LocalDate returnDate = dateReturn.getValue();

            long overdueDays = returnController.calculateOverdueDays(dueDate, returnDate);

            if (overdueDays > 0) {
                lblOverdueStatus.setText("OVERDUE by " + overdueDays + " day(s)!");
                lblOverdueStatus.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            } else {
                lblOverdueStatus.setText("Status: On Time");
                lblOverdueStatus.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            }
        }
    }

    @FXML
    void btnOnActionReturnBook(ActionEvent event) {
        String issueId = txtSearchIssueId.getText().trim();

        if (issueId.isEmpty() || txtMemberInfo.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Selection Required", "Please search and select a valid borrowed record first.");
            return;
        }

        boolean success = returnController.returnBook(issueId);

        if (success) {
            showAlert(Alert.AlertType.INFORMATION, "Success", "Book returned successfully!");
            clearForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to process book return.");
        }
    }

    private void clearForm() {
        txtSearchIssueId.clear();
        txtMemberInfo.clear();
        txtBookInfo.clear();
        dateBorrow.setValue(null);
        dateDue.setValue(null);
        dateReturn.setValue(LocalDate.now());
        lblOverdueStatus.setText("");
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}