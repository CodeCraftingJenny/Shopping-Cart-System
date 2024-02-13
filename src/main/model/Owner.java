package model;

import java.awt.*;
import java.util.List;

import model.Customer;

public class Owner {

    //Constructs the owner of the business who can manage the incoming sales
    public Owner() {

    }

    //REQUIRES: customer much not have an empty cart
    //EFFECTS: see items that are in customer's cart
    public List<Customer> viewCustomerOrder() {
        return null;
    }

    //MODIFIES: this
    //EFFECTS: changes status of order to either in progress, in transit, completed
    public String changeStatus(String status) {
        return "";
    }

    //MODIFIES: this
    //EFFECTS: sends notification to customer about order status
    public String sendNotification(String message) {
        return "";
    }
}
