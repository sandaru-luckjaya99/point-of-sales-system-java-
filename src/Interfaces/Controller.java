package Interfaces;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

// containers of scene builder
    public TextField username;
    public PasswordField pwd;

    // when the loggin button pressed
    public void button(ActionEvent actionEvent) {

        // when the logging success
        if (   pwd.getText().equals("database")  && username.getText().equals("Sandaru")  ){



        }

        //when the login failed
        else{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Loging information");
            alert.setHeaderText("plese try again");
            alert.setContentText("The password or user name you entered is incorrect ");
            alert.showAndWait();

        }


    }
}
