package model;

public class Clothing {

    private String nameOfItem;
    private char size;
    private double price;
    private String colour;


    // Creates a clothing item that customer can customize and purchase
    public Clothing(String nameOfItem, String colour, Character size, double price) {
        this.nameOfItem = nameOfItem;
        this.size = size;
        this.price = price;
        this.colour = colour;
    }

    public Character getSize() {
        return this.size;
    }

    public String getColour() {
        return this.colour;
    }

    public String getNameOfItem() {

        return this.nameOfItem;
    }

    public double getPrice() {
        return this.price;
    }



}
