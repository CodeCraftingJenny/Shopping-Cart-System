package model;

import java.util.List;

public class Order {

    private Customer customer;
    private List<Clothing> orderItems;
    private String status;

    public Order(Customer customer, List<Clothing> orderItems) {
        this.customer = customer;
        this.orderItems = orderItems;
        this.status = "Pending";
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Clothing> getOrderItems() {
        return orderItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
