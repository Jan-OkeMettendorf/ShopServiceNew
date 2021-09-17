package de_neuefische.shop;

import de_neuefische.repo.OrderRepo;
import de_neuefische.repo.ProductRepo;
import de_neuefische.modul.Order;
import de_neuefische.modul.Product;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    public void TestGetProduct(){
        // GIVEN
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Playstation"));
        products.add(new Product(2, "Ninteno Switch"));
        products.add(new Product(3, "Dreamcast"));
        ProductRepo productRepo = new ProductRepo(products);
        ShopService productListOneProduct = new ShopService(productRepo);
        //WHEN
        Product actual = productListOneProduct.getProduct(1);
        Product expected = new Product(1, "Playstation");

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void TestListProducts(){
        //GIVEN
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Playstation"));
        products.add(new Product(2, "Ninteno Switch"));
        products.add(new Product(3, "Dreamcast"));
        ProductRepo productRepo = new ProductRepo(products);
        ShopService productList = new ShopService(productRepo);

        //WHEN
        List<Product> actual = productList.listProducts();
        List<Product> expected = new ArrayList<>(List.of(
                new Product(1, "Playstation"),
                new Product(2, "Ninteno Switch"),
                new Product(3, "Dreamcast")
        ));

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetOrder(){
        //GIVEN
        List<Order> orders = new ArrayList<>(List.of(
                new Order(1, new Product(1,"Playstation")),
                new Order(2, new Product(1,"Playstation")),
                new Order(3, new Product(2,"Dreamcast"))
        ));
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService orderList = new ShopService(orderRepo);

        //WHEN

        Order actual = orderList.getOrder(2);
        Order expected = new Order(2, new Product(1,"Playstation"));

        assertEquals(expected, actual);

    }

    @Test
    public void TestGetOrderList(){
        //GIVEN
        List<Order> orders = new ArrayList<>(List.of(
                new Order(1, new Product(1,"Playstation")),
                new Order(2, new Product(1,"Playstation")),
                new Order(3, new Product(2,"Dreamcast"))
        ));
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService orderList = new ShopService(orderRepo);

        //WHEN

        List<Order> actual = orderList.listOrders();
        List<Order> expected = new ArrayList<>(orders);

        assertEquals(expected,actual);
    }

    @Test
    public void TestAddOrderToExistingOrder(){
        //GIVEN
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Playstation"));
        products.add(new Product(2, "Ninteno Switch"));
        products.add(new Product(3, "Dreamcast"));
        ProductRepo productRepo = new ProductRepo(products);

        List<Order> orders = new ArrayList<>(List.of(
                new Order(1, new Product(1,"Playstation")),
                new Order(2, new Product(1,"Playstation")),
                new Order(3, new Product(3,"Dreamcast"))
        ));
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService orderList = new ShopService(orderRepo, productRepo);

        //WHEN

        orderList.addOrder(2);
        List<Order> actual = orderList.listOrders();
        List<Order> expected = new ArrayList<>(List.of(
                new Order(1, new Product(1,"Playstation")),
                new Order(2, new Product(1,"Playstation")),
                new Order(3, new Product(3,"Dreamcast")),
                new Order(4, new Product(2,"Ninteno Switch"))
        ));

        //THEN

        assertEquals(expected, actual);

    }

    @Test
    public void TestExceptionForAddingAnUnknownProduct(){
        //GIVEN
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Playstation"));
        products.add(new Product(2, "Ninteno Switch"));
        products.add(new Product(3, "Dreamcast"));
        ProductRepo productRepo = new ProductRepo(products);

        List<Order> orders = new ArrayList<>(List.of(
                new Order(1, new Product(1,"Playstation")),
                new Order(2, new Product(1,"Playstation")),
                new Order(3, new Product(3,"Dreamcast"))
        ));
        OrderRepo orderRepo = new OrderRepo(orders);
        ShopService orderList = new ShopService(orderRepo, productRepo);

        //WHEN
        try {
            orderList.addOrder(4);
        } catch (RuntimeException e){
            //THEN
            String actual = e.getMessage();
            String excepted = "The Product you want to add does not exists.";
            assertEquals(excepted, actual);
        }

    }

    @Test
    public void TestGetProductOptionalFalse(){
        // GIVEN
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Playstation"));
        products.add(new Product(2, "Ninteno Switch"));
        products.add(new Product(3, "Dreamcast"));
        ProductRepo productRepo = new ProductRepo(products);
        ShopService productListOneProduct = new ShopService(productRepo);
        //WHEN
        Optional<Product> actual = productListOneProduct.getProductOptional(4);
        Optional<Product> expected = Optional.empty();

        //THEN
        assertEquals(expected, actual);
    }

}