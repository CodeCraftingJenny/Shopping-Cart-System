package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Customer {

    private String name;
    private ArrayList<Clothing> cart;
    private int counter;
    private double total;
    private Clothing clothing;

    // Creates a customer that can add/remove items to their cart
    public Customer(String name) {
        this.name = name;
        this.cart = new ArrayList<>();
    }

    //REQUIRES: shopping cart is not empty
    //MODIFIES: this
    //EFFECTS: returns number of items in cart
    public int getTotalNumberItemsOrdered() {
        this.counter = 0;
        for (Clothing clothing : cart) {
            counter++;
        }
        return counter;
    }

    //MODIFIES: this
    //EFFECTS: adds clothing item to customer's cart
    public void addToCart(Clothing item) {
        this.cart.add(item);
    }

    //REQUIRES: shopping cart is not empty
    //MODIFIES: this
    //EFFECTS: removes item in customer's cart
    public void removeInCart(Clothing item) {
        this.cart.remove(item);
    }

    //EFFECTS: return list of items in cart
    public List<Clothing> viewCart() {
        return cart;
    }

    //EFFECTS: checks if cart is empty
    public boolean cartIsEmpty() {
        if (cart.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //REQUIRES: Cart to be not empty
    //MODIFIES: this
    //EFFECTS: removes all items from cart
    public void emptyCart() {
        cart.clear();
    }

    //EFFECTS: return total monetary amount of items in cart
    public double getTotal() {
        this.total = 0;
        for (Clothing clothing : cart) {
            total += clothing.getPrice();
        }
        return total;
    }

}
