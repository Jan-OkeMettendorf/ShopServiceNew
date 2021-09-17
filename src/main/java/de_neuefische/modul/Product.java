package de_neuefische.modul;

import java.util.Objects;

public class Product {

    // variables

    private int productID;
    private String productName;

    // constructors

    public Product(int productID, String productName){
        this.productID = productID;
        this.productName = productName;
    }

    // getter & setter

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // equals & hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productID == product.productID && Objects.equals(productName, product.productName);
    }

    // toString

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, productName);
    }


}
