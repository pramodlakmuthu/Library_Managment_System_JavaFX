package Controllers.AddBook;

import Model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Add_Book_Page_Controller {

    private BookController bookController = new BookController();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtISBN;

    @FXML
    private TextField txtPublishedYear;

    @FXML
    private TextField txtQuantity;

    @FXML
    void btnOnActionAddBook(ActionEvent event) {
        // Validate empty fields
        if (txtISBN.getText().trim().isEmpty() || txtBookTitle.getText().trim().isEmpty() ||
                txtAuthor.getText().trim().isEmpty() || txtCategory.getText().trim().isEmpty() ||
                txtPublishedYear.getText().trim().isEmpty() || txtQuantity.getText().trim().isEmpty()) {

            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill in all input fields!");
            return;
        }

        try {
            String isbn = txtISBN.getText().trim();
            String title = txtBookTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            String category = txtCategory.getText().trim();
            int year = Integer.parseInt(txtPublishedYear.getText().trim());
            int quantity = Integer.parseInt(txtQuantity.getText().trim());

            // Instantiate Book object and pass to controller
            Book book = new Book(isbn, title, author, category, year, quantity);
            boolean isAdded = bookController.addBook(book);

            if (isAdded) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Book successfully added to the system!");
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to add the book!");
            }

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Published Year and Quantity must be valid integers!");
        }
    }

    @FXML
    void btnOnActionClear(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtISBN.clear();
        txtBookTitle.clear();
        txtAuthor.clear();
        txtCategory.clear();
        txtPublishedYear.clear();
        txtQuantity.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }
}