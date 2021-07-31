// Business table operator

package Interfaces;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class table3 {

    private SimpleIntegerProperty billno;
    private SimpleDoubleProperty price;
    private SimpleStringProperty user;

    public table3(Integer billno, Double price, String user) {

        this.billno = new SimpleIntegerProperty(billno);
        this.price = new SimpleDoubleProperty(price);
        this.user = new SimpleStringProperty(user);


    }

    public int getBillno() {
        return billno.get();
    }

    public SimpleIntegerProperty billnoProperty() {
        return billno;
    }

    public void setBillno(int billno) {
        this.billno.set(billno);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public String getUser() {
        return user.get();
    }

    public SimpleStringProperty userProperty() {
        return user;
    }

    public void setUser(String user) {
        this.user.set(user);
    }
}
