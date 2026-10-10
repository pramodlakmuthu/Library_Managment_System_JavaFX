package Controllers.AddBook;

import Controllers.AddBook.BookController;

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
    private Button btnReset;

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

        if (txtISBN.getText().trim().isEmpty() ||
                txtBookTitle.getText().trim().isEmpty() ||
                txtAuthor.getText().trim().isEmpty() ||
                txtCategory.getText().trim().isEmpty() ||
                txtPublishedYear.getText().trim().isEmpty() ||
                txtQuantity.getText().trim().isEmpty()) {

            showAlert(Alert.AlertType.WARNING, "Validation Warning", "Missing Information", "Please fill in all fields before adding a book.");
            return;
        }

        try {
            // 2. Parse text fields to appropriate data types
            String isbn = txtISBN.getText().trim();
            String title = txtBookTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            String category = txtCategory.getText().trim();
            int publishedYear = Integer.parseInt(txtPublishedYear.getText().trim());
            int quantity = Integer.parseInt(txtQuantity.getText().trim());

            // 3. Create the Book model object
            Book book = new Book(isbn, title, author, category, publishedYear, quantity);

            // 4. Save via BookController
            boolean isAdded = bookController.addBook(book);

            if (isAdded) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Book Added", "Book successfully saved to the system!");
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Operation Failed", "Failed to add the book!");
            }

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Invalid Data Type", "Published Year and Quantity must be valid numeric values!");
        }
    }

    @FXML
    void btnOnActionReset(ActionEvent event) {
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

    private void showAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }
}