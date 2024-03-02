package model;

import org.json.JSONObject;
import persistence.Writable;

public class Clothing implements Writable {

    private String nameOfItem;
    private String size;
    private double price;
    private String colour;

    // Creates a clothing item that customer can purchase
    // Clothing has a name, size, and colour, price is set
    public Clothing(String nameOfItem, String colour, String size) {
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

    //EFFECTS: get size of item
    public String getSize() {
        return this.size;
    }

    //MODIFIES: this
    //EFFECTS: sets size of item
    public String setSize(String size) {
        switch (size) {
            case "S":
                return this.size = "S";
            case "M":
                return this.size = "M";
            case "L":
                return this.size = "L";
            default:
                return this.size = "X";
        }
    }

    //EFFECTS: get colour of item
    public String getColour() {
        return this.colour;
    }

    //MODIFIES: this
    //EFFECTS: sets colour of item
    public String setColour(String colour) {
        switch (colour) {
            case "white":
                return this.colour = "white";
            case "black":
                return this.colour = "black";
            default:
                return this.colour = "Invalid option";
        }
    }

    //EFFECTS: get name of item
    public String getNameOfItem() {
        return this.nameOfItem;
    }

    //EFFECTS: get price of item
    public double getPrice() {
        return price;
    }

    @Override
    //EFFECTS: returns JSONObject that represents clothing
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.nameOfItem);
        json.put("colour", this.colour);
        json.put("size", this.size);
        return json;
    }
}