package de_neuefische.repo;

import de_neuefische.modul.Order;
import de_neuefische.modul.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    public void TestList(){

        // GIVEN
        List<Order> orders = new ArrayList<>(List.of(
                new Order(1, new Product(1,"Playstation")),
                new Order(2, new Product(1,"Playstation")),
                new Order(3, new Product(2,"Dreamcast"))
        ));
        OrderRepo orderRepo = new OrderRepo(orders);

        //WHEN

        List<Order> expected = new ArrayList<>(List.of(
                new Order(1, new Product(1,"Playstation")),
                new Order(2, new Product(1,"Playstation")),
                new Order(3, new Product(2,"Dreamcast"))
        ));
        List<Order> actual = orderRepo.list();

        //THEN

        assertEquals(expected, actual);

    }
    @Test
    public void TestGetOrder(){
        // GIVEN
        List<Order> orders = new ArrayList<>(List.of(
                new Order(1, new Product(1,"Playstation")),
                new Order(2, new Product(1,"Playstation")),
                new Order(3, new Product(2,"Dreamcast"))
        ));
        OrderRepo orderRepo = new OrderRepo(orders);

        //WHEN
        Order actual = orderRepo.get(1);
        Order expected = new Order(1, new Product(1,"Playstation"));

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void TestAddOrder(){
        // GIVEN
        List<Order> orders = new ArrayList<>(List.of(
                new Order(1, new Product(1,"Playstation")),
                new Order(2, new Product(1,"Playstation")),
                new Order(3, new Product(2,"Dreamcast"))
        ));
        OrderRepo orderRepo = new OrderRepo(orders);
        orderRepo.add(4,new Product(3,"Nintendo Switch"));
        List<Order> actual = orderRepo.list();
        List<Order> expected = new ArrayList<>(List.of(
                new Order(1, new Product(1,"Playstation")),
                new Order(2, new Product(1,"Playstation")),
                new Order(3, new Product(2,"Dreamcast")),
                new Order(4, new Product(3,"Nintendo Switch"))
        ));

        assertEquals(expected, actual);

    }
}