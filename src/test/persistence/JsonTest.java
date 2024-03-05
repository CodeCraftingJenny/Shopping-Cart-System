package persistence;

import model.Clothing;
import model.Customer;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkClothing(String nameOfItem, String colour, String size, Clothing clothing) {
    assertEquals(nameOfItem, clothing.getNameOfItem());
    assertEquals(colour, clothing.getColour());
    assertEquals(size, clothing.getSize());
    }
}
