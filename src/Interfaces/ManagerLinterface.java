package Interfaces;

import connection.connectioncls;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ManagerLinterface {

    @FXML
    private TableView< table3> tableview3;

    @FXML
    private TableColumn<table3, Integer> billno;

    @FXML
    private TableColumn<table3, Double> price;

    @FXML
    private TableColumn<table3, String> user;

    @FXML
    private TextField get_date;

    @FXML

    void serch(MouseEvent event) {

        String date = get_date.getText();

        //Sql connection
        connectioncls connectionCls = new connectioncls();
        Connection connection = connectionCls.getConnection();

        // all details got from database
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *  FROM `billist` WHERE `Date` = ? ");
            preparedStatement.setString(1,date);
            ResultSet billst = preparedStatement.executeQuery();

            while (billst.next()==true){

                observableList.add(new table3 (billst.getInt("bill_no"),billst.getDouble("price"),billst.getString("User")));

            }

        } catch (Exception e){

            e.printStackTrace();

        }


        billno.setCellValueFactory(new PropertyValueFactory<>("billno"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));

        tableview3.setItems(observableList);

    }

    ObservableList<table3> observableList = FXCollections.observableArrayList(

    );

}


