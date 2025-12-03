package lk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.db.Dbconnection;

import java.io.IOException;
import java.sql.*;

public class UsersaveformController {
    public AnchorPane rootNode;
    public TextField fieldemail;
    public PasswordField fieldpassowrd;

    public void RegisterBtn(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/views/registerationform.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public void loginBtn(ActionEvent actionEvent) throws IOException {
        // Validate input fields first
//        if (fieldemail.getText().isEmpty() || fieldpassowrd.getText().isEmpty()) {
//            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill in all fields");
//            return;
//        }

        // Verify credentials
//        boolean isValidUser = verification(fieldemail.getText(), fieldpassowrd.getText());


            // Navigate to main/dashboard screen (not login form again)
            Parent root = FXMLLoader.load(getClass().getResource("/views/LoginForm.fxml"));
            Stage stage = (Stage) rootNode.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Web News - Dashboard");
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();

    }

    private boolean verification(String email, String password) {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";


        try (Connection conn = Dbconnection.getDbconnection().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to connect to database");
            return true;
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}