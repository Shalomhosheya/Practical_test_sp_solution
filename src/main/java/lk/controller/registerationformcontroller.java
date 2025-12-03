package lk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class registerationformcontroller {
    public AnchorPane rootnode;
    public TextField firstname;
    public TextField lastname;
    public TextField email;
    public PasswordField password;

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        boolean connection = saveuser(firstname,lastname,email,password);
        if (connection=true) {
            Parent parent = FXMLLoader.load(getClass().getResource("/views/usersaveform.fxml"));
            Stage stage = (Stage) rootnode.getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();
        }
    }

    private boolean saveuser(TextField firstname, TextField lastname, TextField email, PasswordField password) {
        if (){
            String sql = "insert into table user(?,?,?,?)";
            Connection connection = prepare
        }

        return false;
    }

    public void loginttoBtn(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/usersaveform.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Web News");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
}
