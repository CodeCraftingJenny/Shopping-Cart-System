package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClothingTest {

    private Clothing hoodie;
    private Clothing beanie;
    private Clothing shirt;

    @BeforeEach
    public void setUp() {
        hoodie = new Clothing("HOODIE", "BLUE", 'S', 30.00);
        beanie = new Clothing("BEANIE", "RED", 'L', 10.00);
        shirt = new Clothing("SHIRT", "WHITE", 'M', 15.00);
    }

    @Test
    public void getSizeTest(){
        assertEquals(hoodie.getSize(), 'S');
    }

    @Test
    public void getColourTest(){
        assertEquals(beanie.getColour(), "RED");
    }

    @Test
    public void getNameOfItem(){
        assertEquals(shirt.getNameOfItem(), "SHIRT");
    }

    @Test
    public void getPrice(){
        assertEquals(shirt.getPrice(), 15.00);
    }
}