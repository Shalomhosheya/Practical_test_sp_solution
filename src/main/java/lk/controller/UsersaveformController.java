package lk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UsersaveformController {
    public AnchorPane rootNode;

    public void RegisterBtn(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/views/registerationform.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/loginform.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Web News - Login");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
}
