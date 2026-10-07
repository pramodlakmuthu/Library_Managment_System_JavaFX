package Controllers;

public class LoginController {


    public boolean check_UserName_And_Password(String username, String password) {
        if(username.equals("pramod")&&password.equals("4264")){
            return true;
        }
        return false;
    }
}
