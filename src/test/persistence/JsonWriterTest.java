package persistence;

import model.Clothing;
import model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonWriterTest extends JsonTest {

    private Customer customer;
    private List<Clothing> cart;
    private Clothing hoodie;
    private Clothing beanie;
    private Clothing shirt;

    @BeforeEach
    public void setUp() {
        hoodie = new Clothing("hoodie", "BLUE", "S");
        beanie = new Clothing("beanie", "RED", "L");
        shirt = new Clothing("shirt", "WHITE", "M");
        cart = new ArrayList<>();
    }

    @Test
    void testWriterInvalidFile() {
        try {
            customer = new Customer("Jenny");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("Expected IOException");
        } catch (IOException io) {
            //pass
        }
    }

    @Test
    void testWriterEmptyCart() {
        try {
            customer = new Customer("Jenny");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCustomer.json");
            writer.open();
            writer.write(customer);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCustomer.json");
            customer = reader.read();
            assertEquals("Jenny", customer.getName());
            assertEquals(0, customer.getTotalNumberItemsOrdered());
        } catch (IOException io) {
            fail("Shouldn't have thrown exception");
        }
    }

    @Test
    void testWriterCartWithItems() {
        try {
            customer = new Customer("Jenny");
            customer.addToCart(hoodie);
            customer.addToCart(beanie);
            customer.addToCart(shirt);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCustomer.json");
            writer.open();
            writer.write(customer);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCustomer.json");
            customer = reader.read();
            assertEquals("Jenny", customer.getName());
            assertEquals(3, customer.getTotalNumberItemsOrdered());
            assertTrue(customer.isItemInCart("hoodie"));
            assertTrue(customer.isItemInCart("beanie"));
            assertTrue(customer.isItemInCart("shirt"));
            assertEquals("hoodie", hoodie.getNameOfItem());
            assertEquals("beanie", beanie.getNameOfItem());
            assertEquals("shirt", shirt.getNameOfItem());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}