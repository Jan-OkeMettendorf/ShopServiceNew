package de_neuefische.repo;

import de_neuefische.modul.Order;
import de_neuefische.modul.Product;

import java.security.KeyStore;
import java.util.*;

public class OrderRepo {

    // variables

    private Map<Integer, Order> orders = new TreeMap<>();

    // constructors

    public OrderRepo(){

    }

    public OrderRepo(List<Order> orders){
        add(orders);
    }

    public OrderRepo(Order orders){
        add(orders);
    }

    // methods

    private void add(Order order){

        if (orders.containsKey(order.getOrderID())){
            throw new RuntimeException("The order with this ID already exists");
        }

        orders.put(order.getOrderID(), order);

    }

    private void add(List<Order> orders){
        for (Order order : orders) {
            add(order);
        }
    }

    public Order add(int order, Product product){
        Order newOrder = new Order(order, product);

        return orders.put(order, newOrder);
    }

    public List<Order> list(){
        return new ArrayList<>(orders.values());
    }

    public Order get(int orderID){
        return orders.get(orderID);
    }

    public int getLastKey(){

        return orders.size()+1;

    }

    public int getMapSize(){
        return orders.size();
    }

    // getter

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    // equals & hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRepo orderRepo = (OrderRepo) o;
        return Objects.equals(orders, orderRepo.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders);
    }
}
