package Interfaces;

import com.sun.media.jfxmedia.events.NewFrameEvent;
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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;


public class Controller2 implements Initializable {

    public TextArea Tax;
    public DatePicker calender;
    //public Label timer;
    public Button back;
    public TextField user;
    public TextField billno_txt;
    public TextField discnt_txt;
    public TextField tot_disc_txt;
    public Button get_barcode;

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
    private TableColumn<table_add_list, Double> discounted_column;

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
    private Button add;

    @FXML
    private Button end;

    @FXML
    private TextField price;


    Double totalprice = Double.valueOf(0); // variable to store total value(not last total)

    public String billstr; // variable to store bill numbers string part
    public Integer bil_no;  // variable to store bill numbers int part
    public Double discount; // variable to store discount
    public String username; // variable to store user name

    public Double total_discount = 0.0; // variable to store total discount
    public Double gross_total = 0.0; // variable to store gross discount

    public java.sql.Time localTime;
    public java.sql.Date localDates;

    // method to get date
    public void date(){

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        localDates = java.sql.Date.valueOf(simpleDateFormat.format(new Date()));

    }


    // method get time
    public void clock (){

        Date currentTime = new Date();
        String formatTimestr = "hh:mm:ss";
        DateFormat formatTime = new SimpleDateFormat(formatTimestr);
        localTime = Time.valueOf(formatTime.format(currentTime));

        //timer.setText(String.valueOf(localTime));


    }

    // method to start button
    public void start(MouseEvent mouseEvent) {


        // first of all clear all items of table
        tableView.getItems().clear();
        price.clear();
        tot_disc_txt.clear();
        billno_txt.clear();

        // call time and date
        clock();
        date();

//      sql connection
        connectioncls connectionCls = new connectioncls();
        Connection connection = connectionCls.getConnection();

//      /************ get username  **********/

        // array list to store

        ArrayList<String> logged_list = new ArrayList<>();


        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM logged_user ");
            ResultSet log_user = preparedStatement.executeQuery();

            while ( log_user.next()==true){
                String user = log_user.getString(1);
                logged_list.add(user);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String users = logged_list.get( logged_list.size()-1);

        user.setText(users);

        username = user.getText();

        // Arry list to store bill no
        ArrayList<String> bill_list = new ArrayList<>();

;

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT bill_no FROM billist ");
            ResultSet bil_no = preparedStatement.executeQuery();

            while ( bil_no.next()==true){
                String bils = bil_no.getString(1);

                bill_list.add(bils);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        // Set current bill no and display
        String bilno = bill_list.get( bill_list.size()-1);
        System.out.println(bilno);
        bil_no = Integer.valueOf(bilno);
        bil_no = bil_no+1;
        billstr = ("BILNO " + bil_no);
        billno_txt.setText(billstr);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barcode_column.setCellValueFactory(new PropertyValueFactory<>("barcode_column"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("name_column"));
        quentity_column.setCellValueFactory(new PropertyValueFactory<>("quentity_column"));
        price_column.setCellValueFactory(new PropertyValueFactory<>("price_column"));
        discounted_column.setCellValueFactory(new PropertyValueFactory<>("discounted_column"));

        tableView.setItems(observableList);


    }
    ObservableList<table_add_list>observableList = FXCollections.observableArrayList(

    );

    // method to discount button
    public void discount(MouseEvent mouseEvent) {

        discount = Double.valueOf(discnt_txt.getText());

    }

    // method to add button
    public void add(MouseEvent mouseEvent) {

        if (discount == 0) {

            System.out.println("ddd");

            Double unitprice = Double.valueOf(unitp.getText());
            Integer quentity = Integer.valueOf(qty.getText());
            Double answer = unitprice * quentity;

            totalprice = totalprice + answer;
            Double discount = 0.0;

            gross_total = gross_total + totalprice;

            table_add_list table_add_list = new table_add_list(barcd.getText(),nme.getText(), Integer.parseInt(qty.getText()), answer, discount );
            tableView.getItems().add(table_add_list);

        }

        else {
            System.out.println("SSSS");

            Double unitprice = Double.valueOf(unitp.getText());
            Integer quentity = Integer.valueOf(qty.getText());
            Double answer = unitprice * quentity;

            gross_total = gross_total + answer;


            Double disc = (answer/100) * discount;
            Double discountss = answer - disc;

            totalprice = totalprice + discountss;

            total_discount = total_discount + discountss;

            table_add_list table_add_list = new table_add_list(barcd.getText(), nme.getText(), Integer.parseInt(qty.getText()), answer, discountss);
            tableView.getItems().add(table_add_list);
        }

        unitp.clear();
        barcd.clear();
        brnd.clear();
        qty.clear();
        nme.clear();
        discnt_txt.clear();

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
                discnt_txt.setText(discounts);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void endtot(MouseEvent mouseEvent) throws SQLException  {


        // set totalprice to total field
        price.setText(String.valueOf(totalprice));

        // set billno to bill no field
        billno_txt.setText(billstr);

        // set total discount

        tot_disc_txt.setText( "Gross total = "+ +gross_total +"  "+ "Total discount = " +"   "+total_discount );

        // set billno to bill table(database)
        connectioncls connectionCls = new connectioncls();
        Connection connection = connectionCls.getConnection();

        String pricess = price.getText();

        Double prss = Double.valueOf(pricess);


        String billns2 = " INSERT INTO `billist`(`bill_no`, `Time`,`Date`, `User`, `price`) VALUES ('"+bil_no+"','"+localTime+"', '"+ localDates +"',  '"+username+"','"+prss+"')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(billns2);

    }


    public void clr(MouseEvent mouseEvent) {

        tableView.getItems().clear();

        unitp.clear();
        barcd.clear();
        brnd.clear();
        qty.clear();
        nme.clear();
        discnt_txt.clear();


    }


    public void bck(MouseEvent mouseEvent) throws IOException {

        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Interface 1.fxml"));
        stage.setTitle("Logging");
        stage.setScene(new Scene(root,600,500));

        stage.show();
        //stage.setResizable(true);

    }


    public void get_barcode(MouseEvent mouseEvent) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Interface 5.fxml"));
        Parent root2 = (Parent)  fxmlLoader.load();
        Stage stage = new Stage();get_barcode.getScene().getWindow();
        stage.setTitle("Barcode list");
        stage.setScene(new Scene(root2));
        stage.show();
        //stage.setMaximized(true);


    }
}
