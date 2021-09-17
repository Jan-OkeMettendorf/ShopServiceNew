package de_neuefische.modul;

import java.util.Map;
import java.util.Objects;

public class Order {

    // variables

    private int orderID;
    private Product product;



    // constructors

    public Order(int orderID) {
        this.orderID = orderID;
    }

    public Order(){

    }

    public Order(int orderID, Product product){
        this.orderID = orderID;
        this.product = product;
    }

    // getter & setter

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    // equals & HashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && Objects.equals(product, order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, product);
    }

    // toString


    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", product=" + product +
                '}';
    }
}
