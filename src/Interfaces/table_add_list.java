package Interfaces;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class table_add_list {
    private SimpleIntegerProperty barcode_column;
    private SimpleIntegerProperty quentity_column;
    private SimpleStringProperty name_column;
    private SimpleIntegerProperty price_column;

    public table_add_list(Integer barcode_column, Integer quentity_column, String name_column, Integer price_column) {
        this.barcode_column = new SimpleIntegerProperty(barcode_column);
        this.quentity_column = new SimpleIntegerProperty(quentity_column);
        this.name_column = new SimpleStringProperty( name_column);
        this.price_column = new SimpleIntegerProperty( price_column);
    }

    public Integer getBarcode_column() {
        return barcode_column.get();
    }

//    public SimpleIntegerProperty barcode_columnProperty() {
//        return barcode_column;
//    }

    public void setBarcode_column(Integer barcode_column) {
        this.barcode_column = new SimpleIntegerProperty(barcode_column);
    }

    public Integer getQuentity_column() {
        return quentity_column.get();
    }

//    public SimpleIntegerProperty quentity_columnProperty() {
//        return quentity_column;
//    }

    public void setQuentity_column(Integer quentity_column) {
        this.quentity_column = new SimpleIntegerProperty(quentity_column);
    }

    public String getName_column() {
        return name_column.get();
    }

//    public SimpleStringProperty name_columnProperty() {
//        return name_column;
//    }

    public void setName_column(String name_column) {
        this.name_column=new SimpleStringProperty (name_column);
    }

    public int getPrice_column() {
        return price_column.get();
    }
//
//    public SimpleIntegerProperty price_columnProperty() {
//        return price_column;
//    }

    public void setPrice_column(Integer price_column) {
        this.price_column=new SimpleIntegerProperty (price_column);
    }
}
