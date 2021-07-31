package Interfaces;//package Interfaces;

import javafx.collections.ObservableList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class table2 {
    private SimpleStringProperty Name;
    private SimpleStringProperty brand_column;
    private SimpleStringProperty Barcode_column;


    public table2(String Name, String brand_column, String Barcode_column) {

        this.Name = new SimpleStringProperty(Name);
        this.brand_column = new SimpleStringProperty(brand_column);
        this.Barcode_column = new SimpleStringProperty(Barcode_column);


    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getBrand_column() {
        return brand_column.get();
    }

    public SimpleStringProperty brand_columnProperty() {
        return brand_column;
    }

    public void setBrand_column(String brand_column) {
        this.brand_column.set(brand_column);
    }

    public String getBarcode_column() {
        return Barcode_column.get();
    }

    public SimpleStringProperty barcode_columnProperty() {
        return Barcode_column;
    }

    public void setBarcode_column(String barcode_column) {
        this.Barcode_column.set(barcode_column);
    }
}
