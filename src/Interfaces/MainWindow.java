package Interfaces;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {

    @FXML
    private Button User_log;

    @FXML
    private Button Mannager_log;

    // button to manager log
    @FXML
    void mlg(MouseEvent event) {








    }

    // button to user log
    @FXML
    void ulg(MouseEvent event) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Interface 1.fxml"));
        Parent root2 = (Parent)  fxmlLoader.load();
        Stage stage = new Stage();User_log.getScene().getWindow();
        stage.setTitle("Barcode list");
        stage.setScene(new Scene(root2));
        stage.show();






    }


}











