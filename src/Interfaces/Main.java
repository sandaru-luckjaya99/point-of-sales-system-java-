package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    //public Start start;

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("Main window.fxml"));
        primaryStage.setTitle("loging");
        primaryStage.setScene(new Scene(root, 599.2, 398.4));
        primaryStage.show();

    }


    public static void main(String[] args) {

        launch(args);
    }

}
