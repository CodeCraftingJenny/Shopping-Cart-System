package model;

import java.util.List;

public class Owner {

    private String name;
    private String status;

    //Constructs the owner of the business who can manage the incoming sales
    public Owner(String name) {
        this.name = name;
    }

    //REQUIRES: customer must not have an empty cart
    //EFFECTS: see items that are in customer's cart
    public List<Clothing> viewCustomerOrder(Customer customer) {
        return customer.viewCart();
    }

    //MODIFIES: this
    //EFFECTS: changes status of order to either in progress, in transit, completed
    public String setStatus(String status) {
        return this.status = status;
    }

    public String getStatus() {
        return status;
    }

    //REQUIRES: customer must have completed an order
    //MODIFIES: this
    //EFFECTS: sends notification to customer about order status
    public String sendNotification(String message) {
        if (status.equals("in progress")) {
            return "I am making your order.";
        } else if (status.equals("in transit")) {
            return "I have sent your order to the post office.";
        } else if (status.equals("completed")) {
            return "Your order has been delivered, thank you for shopping with us.";
        }
        return "Order has been received";
    }
}
