package ui;

import model.Clothing;
import model.Customer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("JJ");
        ShoppingInterface shoppingInterface = new ShoppingInterface(customer);
        shoppingInterface.startShopping();
    }
}

