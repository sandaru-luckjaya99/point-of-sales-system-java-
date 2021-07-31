package Interfaces;

import connection.connectioncls;
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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Manager_loggin_intr_cls {

    @FXML
    private PasswordField pwd;

    @FXML
    private Button button;

    @FXML
    private TextField username;



    // method to load manager login if logginn success
    @FXML
    void goNext(MouseEvent event) throws IOException, SQLException {
        if (pwd.getText().equals("pw11") && username.getText().equals("Sandaruwan") ){



            // load manager interface
            Stage stage = (Stage) button.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Manager linterface.fxml"));
            stage.setTitle("Manager");
            stage.setScene(new Scene(root));
            //stage.setMaximized(true);
            stage.showAndWait();

        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Loging information");
            alert.setHeaderText("Plese try againg");
            alert.setContentText("The password or uder name incorrect");
            alert.showAndWait();
        }

    }

}
