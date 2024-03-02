package ui;

import model.Clothing;
import model.Customer;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            Customer customer = new Customer("JJ");
            ShoppingInterface shoppingInterface = new ShoppingInterface(customer);
            shoppingInterface.startShopping();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
