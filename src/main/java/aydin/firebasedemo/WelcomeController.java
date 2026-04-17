package aydin.firebasedemo;

import com.google.firebase.auth.UserRecord;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WelcomeController {

    @FXML private TextField emailField;
    @FXML private TextField passwordField;

    @FXML
    private void onRegister() {
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(emailField.getText())
                    .setPassword(passwordField.getText());

            DemoApp.fauth.createUser(request);

            System.out.println("User registered!");
            DemoApp.setRoot("primary");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onSignIn() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            System.out.println("Missing credentials");
            return;
        }

        try {
            DemoApp.setRoot("primary");
            System.out.println("Sign in successful (demo mode)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}