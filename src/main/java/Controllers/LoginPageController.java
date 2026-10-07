package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {
    LoginController loginController=new LoginController();

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRest;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        if (loginController.check_UserName_And_Password(txtUserName.getText(),txtPassword.getText())){
            Stage stage=new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Main_DashBoard.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Login Failed");
            alert.setContentText("Ivalid UserName Or Password");
            alert.show();
        }


    }

    @FXML
    void btnReserOnAction(ActionEvent event) {
        txtUserName.clear();
        txtPassword.clear();

    }

}
