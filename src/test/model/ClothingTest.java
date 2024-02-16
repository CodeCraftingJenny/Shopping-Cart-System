package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ClothingTest {

    private Clothing hoodie;
    private Clothing beanie;
    private Clothing cap;
    private Clothing totebag;

    @BeforeEach
    public void setUp() {
        hoodie = new Clothing("hoodie", "black", 'S');
        beanie = new Clothing("beanie", "white", 'L');
        cap = new Clothing("cap", "black", 'M');
        totebag = new Clothing("totebag", "black", 'M');

    }

    @Test
    public void getSizeTest(){
        assertEquals(hoodie.getSize(), 'S');
    }

    @Test
    public void getColourTest(){
        assertEquals(beanie.getColour(), "white");
    }

    @Test
    public void getNameOfItem(){
        assertEquals(cap.getNameOfItem(), "cap");
    }

    @Test
    public void getPrice(){
        assertEquals(cap.getPrice(), 15.00);
    }

    @Test
    public void getPriceHoodie(){
        assertEquals(totebag.getPrice(), 10.00);
    }

    @Test
    public void setSizeTestM(){
        assertEquals(hoodie.getSize(), 'S');
        hoodie.setSize('M');
        assertEquals(hoodie.getSize(), 'M');
    }

    @Test
    public void setSizeTestL(){
        assertEquals(hoodie.getSize(), 'S');
        hoodie.setSize('L');
        assertEquals(hoodie.getSize(), 'L');
    }

    @Test
    public void setSizeTestS(){
        assertEquals(cap.getSize(), 'M');
        cap.setSize('S');
        assertEquals(cap.getSize(), 'S');
    }

    @Test
    public void setSizeTestNull(){
        hoodie.setSize('U');
        assertEquals(hoodie.getSize(), 'X');
    }

    @Test
    public void setSizeColourNull(){
        hoodie.setColour("purple");
        assertEquals("Invalid option", hoodie.getColour());

    }

    @Test
    public void setSizeColour(){
        hoodie.setColour("white");
        assertEquals("white", hoodie.getColour());
    }

    @Test
    public void setSizeColourBeanie(){
        beanie.setColour("black");
        assertEquals("black", beanie.getColour());
    }
}