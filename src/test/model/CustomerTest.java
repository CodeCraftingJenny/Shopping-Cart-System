package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private Customer customer;
    private List<Clothing> cart;
    private Clothing hoodie;
    private Clothing beanie;
    private Clothing shirt;

    @BeforeEach
    public void setUp() {
        customer = new Customer("Kari");
        hoodie = new Clothing("hoodie", "BLUE", "S");
        beanie = new Clothing("beanie", "RED", "L");
        shirt = new Clothing("shirt", "WHITE", "M");
        cart = new ArrayList<>();
    }

    @Test
    public void testGetTotalNumberItemsOrdered(){
        customer.addToCart(hoodie);
        customer.addToCart(shirt);
        customer.addToCart(beanie);
        assertEquals(3, customer.getTotalNumberItemsOrdered());
    }

    @Test
    public void testAddToCart(){
        customer.addToCart(hoodie);
        customer.addToCart(shirt);
        assertEquals(2, customer.getTotalNumberItemsOrdered());
    }

    @Test
    public void testRemoveInCart(){
        customer.addToCart(hoodie);
        customer.addToCart(shirt);
        assertEquals(2, customer.getTotalNumberItemsOrdered());
        customer.removeInCart(hoodie);
        assertEquals(1, customer.getTotalNumberItemsOrdered());
    }

    @Test
    public void testViewCart(){
        customer.addToCart(hoodie);
        customer.addToCart(shirt);
        assertEquals(2, customer.getTotalNumberItemsOrdered());
        List<Clothing> cart = customer.viewCart();
        assertTrue(cart.contains(hoodie));
        assertTrue(cart.contains(shirt));
    }

    @Test
    public void testViewCart3(){
        customer.addToCart(hoodie);
        customer.addToCart(beanie);
        customer.addToCart(shirt);
        assertEquals(3, customer.getTotalNumberItemsOrdered());
        List<Clothing> cart = customer.viewCart();
        assertTrue(cart.contains(hoodie));
        assertTrue(cart.contains(shirt));
        customer.removeInCart(beanie);
        assertFalse(cart.contains(beanie));
    }

    @Test
    public void testCartIsEmpty(){
        customer.addToCart(hoodie);
        assertEquals(1, customer.getTotalNumberItemsOrdered());
        customer.removeInCart(hoodie);
        assertTrue(customer.cartIsEmpty());
        assertEquals(0, customer.getTotalNumberItemsOrdered());
    }

    @Test
    public void testCartIsEmptyFalse(){
        customer.addToCart(hoodie);
        assertEquals(1, customer.getTotalNumberItemsOrdered());
        assertFalse(customer.cartIsEmpty());
    }

    @Test
    public void testGetTotal() {
        customer.addToCart(hoodie);
        customer.addToCart(hoodie);
        customer.addToCart(hoodie);
        assertEquals(3, customer.getTotalNumberItemsOrdered());
        assertEquals(150.00, customer.getTotal());
    }


    @Test
    public void testEmptyCart() {
        customer.addToCart(hoodie);
        customer.addToCart(hoodie);
        customer.addToCart(hoodie);
        customer.emptyCart();
        assertTrue(customer.cartIsEmpty());
    }

    @Test
    public void testIsItemInCart() {
        customer.addToCart(hoodie);
        customer.addToCart(beanie);
        customer.addToCart(shirt);
        assertTrue(customer.isItemInCart("hoodie"));
        assertTrue(customer.isItemInCart("beanie"));
        assertTrue(customer.isItemInCart("shirt"));
    }
}

