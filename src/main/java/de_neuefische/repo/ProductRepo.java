package de_neuefische.repo;

import de_neuefische.modul.Product;

import java.util.*;

public class ProductRepo {

    // variables

    private Map<Integer, Product> products = new TreeMap<>();

    // constructors

    public ProductRepo(){

    }

    public ProductRepo(List<Product> products) {
        add(products);
    }

    public ProductRepo(Product product) {
        add(product);
    }

    // methods

    private void add(Product product){
        if (products.containsKey(product.getProductID())) {
            throw new RuntimeException("Product has been already added.");
        }
        products.put(product.getProductID(),product);
    }

    private void add(List<Product> products){
        for (Product product : products) {
            add(product);
        }
    }

    public List<Product> list(){
        return new ArrayList<>(products.values());
    }

    public Product get(int productID) {
        if (!products.containsKey(productID)) {
            throw new RuntimeException("The Product you want to add does not exists.");
        }
        return products.get(productID);
    }

    // getter

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }


    // equals & hashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    // toString


    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}
