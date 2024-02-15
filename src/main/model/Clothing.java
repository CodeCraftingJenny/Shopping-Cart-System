package model;

public class Clothing {

    private String nameOfItem;
    private char size;
    private double price;
    private String colour;

    // Creates a clothing item that customer can customize and purchase
    public Clothing(String nameOfItem, String colour, Character size) {
        this.nameOfItem = nameOfItem;
        this.size = size;
        this.colour = colour;
        switch (nameOfItem) {
            case "hoodie":
                this.price = 50.00;
                break;
            case "cap":
                this.price = 15.00;
                break;
            case "beanie":
                this.price = 15.00;
                break;
            case "totebag":
                this.price = 10.00;
                break;
            default:
                this.price = 0.0;
                break;
        }
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
        return price;
    }

}
