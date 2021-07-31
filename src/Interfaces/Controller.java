package Interfaces;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private PasswordField pwd;

    @FXML
    private Button button;

    @FXML
    private TextField username;

    @FXML
    void goNext(MouseEvent event) throws IOException {
        if (pwd.getText().equals("database") && username.getText().equals("Sandaru")){


            Stage stage = (Stage) button.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Interface 2.fxml"));
            stage.setTitle("Logging");
            stage.setScene(new Scene(root));

        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Loging information");
            alert.setHeaderText("Plese try againg");
            alert.setContentText("The password or uder name incorrect");
            alert.showAndWait();
        }

    }

}
