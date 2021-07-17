package Interfaces;

import connection.connectioncls;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller2 implements Initializable {
    public TextArea Tax;

    @FXML
    private TableView<table_add_list> tableView;

    @FXML
    private TableColumn<table_add_list, String> barcode_column;

    @FXML
    private TableColumn<table_add_list, String> name_column;

    @FXML
    private TableColumn<table_add_list, Integer> quentity_column;

    @FXML
    private TableColumn<table_add_list, Float> price_column;



    @FXML
    private Button strt;

    @FXML
    private TextField unitp;

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

    Float totalprice = Float.valueOf(0);



    //private Object finanswerg;

    //private finanswerg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barcode_column.setCellValueFactory(new PropertyValueFactory<>("barcode_column"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("name_column"));
        quentity_column.setCellValueFactory(new PropertyValueFactory<>("quentity_column"));
        price_column.setCellValueFactory(new PropertyValueFactory<>("price_column"));
        //barcode_column.setCellValueFactory(new PropertyValueFactory<>("Barcode"));


        tableView.setItems(observableList);
    }
    ObservableList<table_add_list>observableList = FXCollections.observableArrayList(

    );



    public void add(MouseEvent mouseEvent) {
        Float unitprice = Float.valueOf(unitp.getText());
        Integer quentity = Integer.valueOf(qty.getText());
        Float answer = unitprice * quentity;

        totalprice = totalprice + answer;
        table_add_list table_add_list = new table_add_list(barcd.getText(),nme.getText(), Integer.parseInt(qty.getText()), answer );
        tableView.getItems().add(table_add_list);

        unitp.clear();
        barcd.clear();
        brnd.clear();
        qty.clear();
        nme.clear();
        discnt.clear();


    }



    @FXML
    void addAll(MouseEvent event) {




    }



    public void enter_search(MouseEvent mouseEvent) throws SQLException {




        connectioncls connectionCls = new connectioncls();
        Connection connection = connectionCls.getConnection();
        try {
            String barcode = barcd.getText();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM instrument WHERE Barcode = ? ");
            preparedStatement.setString(1,barcode);
            ResultSet instrument_detail = preparedStatement.executeQuery();
            if(instrument_detail.next()==true){
                String names = instrument_detail.getString(2);
                String brands = instrument_detail.getString(3);
                String unitprices = instrument_detail.getString(4);
                String discounts = instrument_detail.getString(5);

                nme.setText(names);
                brnd.setText(brands);
                unitp.setText(unitprices);
                discnt.setText(discounts);



            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        //nme.setText();


    }

    public void endtot(MouseEvent mouseEvent) {

        price.setText(String.valueOf(totalprice));
    }
}
