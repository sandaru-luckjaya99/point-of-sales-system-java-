package Interfaces;



import connection.connectioncls;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ResourceBundle;


public class Controller3 implements Initializable {

// TableView
    @FXML
    private TableView<table2> tableView1;

    @FXML
    private TableColumn<table2,String> Name;

    @FXML
    private TableColumn<table2, String> brand_column;

    @FXML
    private TableColumn<table2, String> Barcode_column;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Sql connection
        connectioncls connectionCls = new connectioncls();
        Connection connection = connectionCls.getConnection();

        // all details got from database
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *  FROM `instrument_price_list` ");
            ResultSet barcodelst = preparedStatement.executeQuery();

            while (barcodelst.next()==true){

                observableList.add(new table2(barcodelst.getString("Name"),barcodelst.getString("Brand"),barcodelst.getString("Barcode")));

            }

        } catch (Exception e){

            e.printStackTrace();

        }


        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        brand_column.setCellValueFactory(new PropertyValueFactory<>("brand_column"));
        Barcode_column.setCellValueFactory(new PropertyValueFactory<>("Barcode_column"));

        tableView1.setItems(observableList);


    }

    ObservableList<table2> observableList = FXCollections.observableArrayList(

    );


}
