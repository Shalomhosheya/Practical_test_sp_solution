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

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationFormController {
    public AnchorPane rootnode;
    public TextField firstname;
    public TextField lastname;
    public TextField email;
    public PasswordField password;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/practical_test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "shalom@12344321";

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        // Validate inputs
        if (firstname.getText().isEmpty() || lastname.getText().isEmpty() ||
                email.getText().isEmpty() || password.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill all fields!");
            return;
        }

        boolean success = saveUser(firstname.getText(), lastname.getText(),
                email.getText(), password.getText());

        if (success) {
            showAlert(Alert.AlertType.INFORMATION, "Success", "User registered successfully!");

            Parent parent = FXMLLoader.load(getClass().getResource("/views/usersaveform.fxml"));
            Stage stage = (Stage) rootnode.getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Registration failed. Please try again.");
        }
    }

    private boolean saveUser(String firstName, String lastName, String emailAddr, String pwd) {
        String sql = "INSERT INTO user (firstname, lastname, email, password) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, emailAddr);
            pstmt.setString(4, pwd); // Consider hashing the password in production

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void loginttoBtn(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/loginform.fxml"));
        Stage stage = (Stage) rootnode.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Web News - Login");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}