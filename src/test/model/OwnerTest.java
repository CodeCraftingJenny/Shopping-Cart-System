package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OwnerTest {
    private Clothing hoodie;
    private Clothing beanie;
    private Clothing shirt;
    private Customer customer;
    private List<Clothing> cart;
    private Owner owner;

    @BeforeEach
    public void setUp() {
        owner = new Owner("JJ");
        customer = new Customer("Kari");
        cart = new ArrayList<>();
        hoodie = new Clothing("HOODIE", "BLUE", 'S');
        beanie = new Clothing("BEANIE", "RED", 'L');
        shirt = new Clothing("SHIRT", "WHITE", 'M');
    }

    @Test
    public void testViewOrder(){
        customer.addToCart(hoodie);
        customer.addToCart(beanie);
        customer.addToCart(shirt);
        assertEquals(3, customer.getTotalNumberItemsOrdered());
        List<Clothing> cart = owner.viewCustomerOrder(customer);
        assertTrue(cart.contains(hoodie));
        assertTrue(cart.contains(shirt));
        customer.removeInCart(beanie);
        assertFalse(cart.contains(beanie));
    }

    @Test
    public void testChangeStatus(){
        customer.addToCart(hoodie);
        customer.addToCart(beanie);
        customer.addToCart(shirt);
        assertEquals(3, customer.getTotalNumberItemsOrdered());
        List<Clothing> cart = owner.viewCustomerOrder(customer);
        assertTrue(cart.contains(hoodie));
        assertTrue(cart.contains(shirt));
        customer.removeInCart(beanie);
        assertFalse(cart.contains(beanie));
        assertEquals (owner.setStatus("in progress"), owner.getStatus());
    }

    @Test
    public void testSendNotificationIP(){
        customer.addToCart(hoodie);
        customer.addToCart(beanie);
        customer.addToCart(shirt);
        assertEquals(3, customer.getTotalNumberItemsOrdered());
        List<Clothing> cart = owner.viewCustomerOrder(customer);
        assertTrue(cart.contains(hoodie));
        assertTrue(cart.contains(shirt));
        customer.removeInCart(beanie);
        assertFalse(cart.contains(beanie));
        assertEquals (owner.setStatus("in progress"), owner.getStatus());
        assertEquals(owner.sendNotification("in progress"), "I am making your order.");
    }

    @Test
    public void testSendNotificationIT(){
        assertEquals (owner.setStatus("in transit"), owner.getStatus());
        assertEquals(owner.sendNotification("in transit"), "I have sent your order to the post office.");
    }

    @Test
    public void testSendNotificationC(){
        assertEquals (owner.setStatus("completed"), owner.getStatus());
        assertEquals(owner.sendNotification("completed"), "Your order has been delivered, thank you for shopping with us.");
    }

    @Test
    public void testSendNotificationNone(){
        assertEquals (owner.setStatus(""), owner.getStatus());
        assertEquals(owner.sendNotification(""), "Order has been received");
    }
}
