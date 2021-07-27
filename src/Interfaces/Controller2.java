package Interfaces;

import com.sun.media.jfxmediaimpl.platform.Platform;
import connection.connectioncls;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;


public class Controller2 implements Initializable {

    public TextArea Tax;
    public DatePicker calender;
    public Label timer;
    public Button back;
    public TextField user;
    public TextField billno_txt;


    @FXML
    private TableView<table_add_list> tableView;

    @FXML
    private TableColumn<table_add_list, String> barcode_column;

    @FXML
    private TableColumn<table_add_list, String> name_column;

    @FXML
    private TableColumn<table_add_list, Integer> quentity_column;

    @FXML
    private TableColumn<table_add_list, Double> price_column;

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
    Double totalprice = Double.valueOf(0);



    private int hours;
    private int minutes;
    private int seconds;







    public void clock (){

        Date currentTime = new Date();
        String formatTimestr = "hh:mm:ss";
        DateFormat formatTime = new SimpleDateFormat(formatTimestr);
        String formattedTimerStr = formatTime.format(currentTime);

        timer.setText(formattedTimerStr);

    }



    public void start(MouseEvent mouseEvent) {

        // Arry list to store bill no
        ArrayList<String> bill_list = new ArrayList<>();

        clock();
        LocalDate date = calender.getValue();
        System.out.println(date);



        connectioncls connectionCls = new connectioncls();
        Connection connection = connectionCls.getConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT biln FROM billist ");
            ResultSet bil_no = preparedStatement.executeQuery();

            while ( bil_no.next()==true){
                String bils = bil_no.getString(1);

                bill_list.add(bils);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }





        String bilno = bill_list.get( bill_list.size()-1 );
        bilno = bilno + 1;

        billno_txt.setText("BILNO "+bilno);










    }

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
        Double unitprice = Double.valueOf(unitp.getText());
        Integer quentity = Integer.valueOf(qty.getText());
        Double answer = unitprice * quentity;

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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM instrument_price_list WHERE Barcode = ? ");
            preparedStatement.setString(1,barcode);
            ResultSet instrument_detail = preparedStatement.executeQuery();

            if(instrument_detail.next()==true){
                String names = instrument_detail.getString(2);
                String brands = instrument_detail.getString(3);
                Double unitprices = instrument_detail.getDouble(4);
                String discounts = instrument_detail.getString(5);

                nme.setText(names);
                brnd.setText(brands);
                unitp.setText(String.valueOf(unitprices));
                discnt.setText(discounts);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void endtot(MouseEvent mouseEvent) {

        price.setText(String.valueOf(totalprice));
//        tableView.getItems().clear();
    }


    public void clr(MouseEvent mouseEvent) {

        tableView.getItems().clear();

        unitp.clear();
        barcd.clear();
        brnd.clear();
        qty.clear();
        nme.clear();
        discnt.clear();


    }


    public void bck(MouseEvent mouseEvent) throws IOException {

        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Interface 1.fxml"));
        stage.setTitle("Logging");
        stage.setScene(new Scene(root,600,500));

        stage.show();
        //stage.setResizable(true);

    }
}
