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

public class JsonReaderTest extends JsonTest{
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
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            customer = reader.read();
            fail("Expected IOException");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCustomer.json");
        try {
            customer= reader.read();
            assertEquals("Jenny", customer.getName());
            assertEquals(0, customer.getTotalNumberItemsOrdered());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testReaderCartWithItems() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCustomer.json");
        try {
            customer = reader.read();
            assertEquals("Jenny", customer.getName());
            assertEquals(3, customer.getTotalNumberItemsOrdered());
            assertTrue(customer.isItemInCart("hoodie"));
            assertTrue(customer.isItemInCart("beanie"));
            assertTrue(customer.isItemInCart("shirt"));
            assertEquals("hoodie", hoodie.getNameOfItem());
            assertEquals("beanie", beanie.getNameOfItem());
            assertEquals("shirt", shirt.getNameOfItem());
        } catch (IOException io) {
            fail("Exception should not have been thrown");
        }
    }
}