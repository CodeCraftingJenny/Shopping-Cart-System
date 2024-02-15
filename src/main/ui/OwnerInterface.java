package ui;

import model.Customer;
import model.Owner;

import java.util.Scanner;

public class OwnerInterface {

    private Owner owner;
    private Scanner scanner;

    public OwnerInterface(Owner owner) {
        this.owner = owner;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to your store!");
        System.out.println("1. View Orders");
        System.out.println("2. Change Status of Order");
        System.out.println("3. Send a notification");
        System.out.println("4. Exit");
    }

    public void startInterface(){}



}
