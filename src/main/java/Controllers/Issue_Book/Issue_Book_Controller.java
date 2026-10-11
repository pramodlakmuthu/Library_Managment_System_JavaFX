package Controllers.Issue_Book;

import Controllers.AddBook.BookController;
import Controllers.AddMember.MemberController;
import Model.Book;
import Model.IssueBook;
import Model.Members;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Issue_Book_Controller implements Initializable {

    @FXML private TextField txtIssueId;
    @FXML private ComboBox<String> cmbMembers;
    @FXML private ComboBox<String> cmbBooks;
    @FXML private DatePicker dateIssue;
    @FXML private DatePicker dateDue;

    private MemberController memberController = new MemberController();
    private BookController bookController = new BookController();
    private IssueController issueController = new IssueController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dateIssue.setValue(LocalDate.now());
        dateDue.setValue(LocalDate.now().plusDays(14));

        loadComboBoxData();
    }

    private void loadComboBoxData() {

        for (Members m : memberController.getAllMembers()) {
            cmbMembers.getItems().add(m.getMemberId() + " - " + m.getName());
        }


        for (Book b : bookController.getAllBooks()) {
            cmbBooks.getItems().add(b.getIsbn() + " - " + b.getTitle());
        }
    }

    @FXML
    void btnOnActionIssueBook(ActionEvent event) {
        String issueId = txtIssueId.getText();
        String selectedMember = cmbMembers.getValue();
        String selectedBook = cmbBooks.getValue();
        LocalDate issueDate = dateIssue.getValue();
        LocalDate dueDate = dateDue.getValue();

        if (issueId.isEmpty() || selectedMember == null || selectedBook == null || issueDate == null || dueDate == null) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill in all fields and make selections!");
            return;
        }

        
        String memberId = selectedMember.split(" - ")[0];
        String isbn = selectedBook.split(" - ")[0];

        IssueBook record = new IssueBook(issueId, memberId, isbn, issueDate, dueDate);
        boolean isIssued = issueController.issueBook(record);

        if (isIssued) {
            showAlert(Alert.AlertType.INFORMATION, "Success", "Book issued successfully!");
            clearForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to issue book.");
        }
    }

    @FXML
    void btnOnActionClear(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        txtIssueId.clear();
        cmbMembers.getSelectionModel().clearSelection();
        cmbBooks.getSelectionModel().clearSelection();
        dateIssue.setValue(LocalDate.now());
        dateDue.setValue(LocalDate.now().plusDays(14));
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}