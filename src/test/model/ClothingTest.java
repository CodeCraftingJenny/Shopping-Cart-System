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
        hoodie = new Clothing("hoodie", "BLUE", 'S');
        beanie = new Clothing("beanie", "RED", 'L');
        shirt = new Clothing("shirt", "WHITE", 'M');
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