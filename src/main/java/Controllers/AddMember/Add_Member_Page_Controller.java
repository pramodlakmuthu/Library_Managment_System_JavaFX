package Controllers.AddMember;

import Model.Members;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Add_Member_Page_Controller {

    @FXML private TextField txtMemberID; // Must match fx:id="txtMemberID"
    @FXML private TextField txtFullName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtContactNb;
    @FXML private TextField txtAddress;

    @FXML private Button btnAddMember;
    @FXML private Button btnReset;

    private MemberController memberController = new MemberController();

    @FXML
    void btnOnActionAddMember(ActionEvent event) {
        String memberId = txtMemberID.getText();
        String name = txtFullName.getText();
        String email = txtEmail.getText();
        String mobile = txtContactNb.getText();
        String address = txtAddress.getText();

        if (memberId.isEmpty() || name.isEmpty() || email.isEmpty() || mobile.isEmpty() || address.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill in all fields!");
            return;
        }

        Members member = new Members(memberId, name, email, address, mobile);
        boolean isAdded = memberController.addMember(member);

        if (isAdded) {
            showAlert(Alert.AlertType.INFORMATION, "Success", "Member registered successfully!");
            clearFields();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to register member. ID might already exist.");
        }
    }

    @FXML
    void btnOnActionReset(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtMemberID.clear();
        txtFullName.clear();
        txtEmail.clear();
        txtContactNb.clear();
        txtAddress.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}