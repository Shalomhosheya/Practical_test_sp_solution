package lk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboardcontroller {
    public AnchorPane rootnode;

    public void sportsbtn(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/views/sportsform.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void entertainbtn(ActionEvent actionEvent) {
    }

    public void newsbtn(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/views/LoginForm.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
}
