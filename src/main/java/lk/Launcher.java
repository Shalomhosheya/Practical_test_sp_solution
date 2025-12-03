package practical_news;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/LoginForm.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Web News");
        stage.setScene(scene);
        stage.show();
    }
}