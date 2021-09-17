package de_neuefische.repo;
import de_neuefische.modul.Product;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {



    @Test
    public void TestList(){
        // GIVEN
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Playstation"));
        products.add(new Product(2, "Ninteno Switch"));
        products.add(new Product(3, "Dreamcast"));
        ProductRepo productRepo = new ProductRepo(products);
        // WHEN
        List<Product> actual = productRepo.list();
        List<Product> expected = new ArrayList<>(List.of(
                new Product(1, "Playstation"),
                new Product(2, "Ninteno Switch"),
                new Product(3, "Dreamcast")
        ));
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void TestGet(){
        // GIVEN
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Playstation"));
        products.add(new Product(2, "Ninteno Switch"));
        products.add(new Product(3, "Dreamcast"));
        ProductRepo productRepo = new ProductRepo(products);

        //WHEN
        Product actual = productRepo.get(1);
        Product expected = new Product(1, "Playstation");

        //THEN
        assertEquals(expected, actual);
    }

}