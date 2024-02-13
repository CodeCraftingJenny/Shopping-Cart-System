package model;

import java.util.LinkedList;
import java.util.List;

public class Customer {

    private String name;
    private List<Clothing> cart;

    // Creates a customer that can purchase and customize items
    public Customer(String name) {
        this.name = name;
        cart = new LinkedList<>();
    }

    //REQUIRES: shopping cart is not empty
    //MODIFIES: this
    //EFFECTS: returns number of items in cart
    public int getTotalNumberItemsOrdered() {
        return 0;
    }

    //MODIFIES: this
    //EFFECTS: adds clothing item to customer's cart
    public void addToCart(Clothing item) {
    }

    //REQUIRES: shopping cart is not empty
    //MODIFIES: this
    //EFFECTS: removes item in customer's cart
    public void removeInCart(Clothing item) {
    }

    //EFFECTS: view items in customer's cart
    public List<Clothing> viewCart() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }


}
