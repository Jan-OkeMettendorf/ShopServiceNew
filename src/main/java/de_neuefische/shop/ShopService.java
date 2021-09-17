package de_neuefische.shop;

import de_neuefische.repo.OrderRepo;
import de_neuefische.repo.ProductRepo;
import de_neuefische.modul.Order;
import de_neuefische.modul.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ShopService {

    // variables

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    // constructors

    public ShopService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    public ShopService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }
    public ShopService(OrderRepo orderRepo, ProductRepo productRepo){
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    // methods

    public Product getProduct(int productID) {
        return productRepo.get(productID);
    }

    public Optional<Product> getProductOptional(int productID){
        Optional<Product> foundProduct = Optional.ofNullable(this.productRepo.get(productID));
        return foundProduct;
    }

    public List<Product> listProducts(){
        return productRepo.list();
    }

    public void addOrder(int productNumber){

        Product existingProduct = getProduct(productNumber);


        int newOrder = orderRepo.getLastKey();
        orderRepo.add(newOrder,existingProduct);
    }

    public void addOrder(int orderNumber, int productNumber){
        Product existingProduct = getProduct(productNumber);
        orderRepo.add(orderNumber,existingProduct);
    }

    public Order getOrder(int orderID){
        return orderRepo.get(orderID);
    }

    public List<Order> listOrders(){
        return orderRepo.list();
    }

    // equals & HashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderRepo, that.orderRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderRepo);
    }

    // toString method

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderRepo=" + orderRepo +
                '}';
    }

}
