package ui;

import model.Clothing;
import model.Customer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("JJ");
        Clothing hoodie = new Clothing("HOODIE", "BLUE", 'S', 30.00);
        Clothing beanie = new Clothing("BEANIE", "RED", 'L', 10.00);
        Clothing shirt  = new Clothing("SHIRT", "WHITE", 'M', 15.00);

        customer.addToCart(hoodie);
        customer.addToCart(beanie);
        customer.addToCart(shirt);
        customer.viewCart();
    }
}
