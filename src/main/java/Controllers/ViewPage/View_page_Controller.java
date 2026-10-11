package Controllers.ViewPage;

import Controllers.AddMember.MemberController;
import Model.Members;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class View_page_Controller implements Initializable {

    @FXML private TableView<Members> tblMembers;
    @FXML private TableColumn<Members, String> colMemberId;
    @FXML private TableColumn<Members, String> colName;
    @FXML private TableColumn<Members, String> colEmail;
    @FXML private TableColumn<Members, String> colAddress;
    @FXML private TableColumn<Members, String> colMobile;

    @FXML private TextField txtSearch;
    @FXML private TextField txtMemberId;
    @FXML private TextField txtName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtAddress;
    @FXML private TextField txtMobile;

    private MemberController memberController = new MemberController();
    private ObservableList<Members> observableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("enail"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobileNb"));

        loadTableData();

        // Listen for row selection to populate edit form fields
        tblMembers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                fillData(newValue);
            }
        });
    }

    private void loadTableData() {
        observableList = FXCollections.observableArrayList(memberController.getAllMembers());
        tblMembers.setItems(observableList);
    }

    private void fillData(Members member) {
        txtMemberId.setText(member.getMemberId());
        txtName.setText(member.getName());
        txtEmail.setText(member.getEnail());
        txtAddress.setText(member.getAddress());
        txtMobile.setText(member.getMobileNb());
    }

    @FXML
    void txtSearchOnKeyReleased(KeyEvent event) {
        String query = txtSearch.getText().toLowerCase();
        if (query.isEmpty()) {
            tblMembers.setItems(observableList);
            return;
        }

        ObservableList<Members> filteredList = FXCollections.observableArrayList();
        for (Members m : observableList) {
            if (m.getName().toLowerCase().contains(query) || m.getMemberId().toLowerCase().contains(query)) {
                filteredList.add(m);
            }
        }
        tblMembers.setItems(filteredList);
    }

    @FXML
    void btnOnActionUpdate(ActionEvent event) {
        String id = txtMemberId.getText();
        if (id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Selection Required", "Please select a member from the table to update.");
            return;
        }

        Members updatedMember = new Members(
                id,
                txtName.getText(),
                txtEmail.getText(),
                txtAddress.getText(),
                txtMobile.getText()
        );

        boolean isUpdated = memberController.updateMember(updatedMember);
        if (isUpdated) {
            showAlert(Alert.AlertType.INFORMATION, "Success", "Member details updated successfully!");
            loadTableData();
            clearForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to update member.");
        }
    }

    @FXML
    void btnOnActionDelete(ActionEvent event) {
        String id = txtMemberId.getText();
        if (id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Selection Required", "Please select a member from the table to delete.");
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete member " + id + "?", ButtonType.YES, ButtonType.NO);
        confirmAlert.showAndWait();

        if (confirmAlert.getResult() == ButtonType.YES) {
            boolean isDeleted = memberController.deleteMember(id);
            if (isDeleted) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Member deleted successfully!");
                loadTableData();
                clearForm();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete member.");
            }
        }
    }

    @FXML
    void btnOnActionClear(ActionEvent event) {
        clearForm();
        tblMembers.getSelectionModel().clearSelection();
    }

    private void clearForm() {
        txtMemberId.clear();
        txtName.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtMobile.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}