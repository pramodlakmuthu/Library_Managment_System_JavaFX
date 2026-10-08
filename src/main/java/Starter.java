import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/LoginPage.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setTitle("Library Management System ");
        stage.setScene(scene);


        stage.setMinWidth(600);
        stage.setMinHeight(450);

        stage.centerOnScreen();
        stage.show();
    }
}