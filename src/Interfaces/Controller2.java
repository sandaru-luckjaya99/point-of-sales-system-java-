package Interfaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller2 implements Initializable {
    public TextArea Tax;

    @FXML
    private TableView<table_add_list> tableView;

    @FXML
    private TableColumn<table_add_list, Integer> barcode_column;

    @FXML
    private TableColumn<table_add_list, Integer> quentity_column;

    @FXML
    private TableColumn<table_add_list, String> name_column;

    @FXML
    private TableColumn<table_add_list, Integer> price_column;



    @FXML
    private Button strt;

    @FXML
    private TextField barcd;

    @FXML
    private TextField brnd;

    @FXML
    private TextField qty;

    @FXML
    private TextField nme;

    @FXML
    private TextField discnt;

    @FXML
    private Button add;

    @FXML
    private Button end;

    @FXML
    private TextField price;



    //private Object finanswerg;

    //private finanswerg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barcode_column.setCellValueFactory(new PropertyValueFactory<>("barcode_column"));
        quentity_column.setCellValueFactory(new PropertyValueFactory<>("quentity_column"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("name_column"));
        //barcode_column.setCellValueFactory(new PropertyValueFactory<>("Barcode"));
        price_column.setCellValueFactory(new PropertyValueFactory<>("price_column"));

        tableView.setItems(observableList);
    }
    ObservableList<table_add_list>observableList = FXCollections.observableArrayList(

    );



    @FXML
    void addAll(MouseEvent event) {


    }


    public void add(MouseEvent mouseEvent) {
        Integer barcode = Integer.valueOf(barcd.getText());
        Integer quentity = Integer.valueOf(qty.getText());
        Integer answer = barcode * quentity;

        table_add_list table_add_list = new table_add_list(Integer.parseInt(barcd.getText()), Integer.parseInt(qty.getText()), nme.getText(), answer);
        tableView.getItems().add(table_add_list);


    }
}
