package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;

import model.Customer;
import model.Clothing;
import model.Event;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.sound.midi.SysexMessage;

public class ShoppingInterface {
    private static final String JSON_STORE = "./data/customer.json";
    private Customer customer;
    private Scanner scanner;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: constructs Customer and runs the application
    public ShoppingInterface(Customer customer) throws FileNotFoundException {
        this.customer = customer;
        this.scanner = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    //EFFECTS: display the menu
    public void displayMenu() {
        System.out.println("Welcome to my store!");
        System.out.println("1. View Catalogue");
        System.out.println("2. Add Item");
        System.out.println("3. Remove Item");
        System.out.println("4. View Cart");
        System.out.println("5. Get Total");
        System.out.println("6. Order Items");
        System.out.println("7. Save Cart");
        System.out.println("8. Load Cart");
        System.out.println("9. Exit");
    }

    // MODIFIES: this
    // EFFECTS: allows for user to choose what they want to do
    @SuppressWarnings("methodlength")
    public void startShopping() {
        boolean shopping = true;
        while (shopping) {
            displayMenu();
            int options = Integer.parseInt(scanner.nextLine());
            switch (options) {
                case 1:
                    viewCatalogue();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    getTotal();
                    break;
                case 6:
                    orderItems();
                    break;
                case 7:
                    saveWorkRoom();
                    break;
                case 8:
                    loadWorkRoom();
                    break;
                case 9:
                    for (Event event : EventLog.getInstance()) {
                        System.out.println(event.toString() + "\n");
                    }
                    shopping = false;
                    System.out.println("Thank you for shopping!");
                    break;
                case 10:
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    //EFFECTS: shows a catalogue of what is in stock
    public void viewCatalogue() {
        System.out.println("Hoodies $50, Caps $15, Beanies $15, Totebags $10");
        System.out.println("Each item comes in either black or white");
        System.out.println("Each item is sized from small (S), medium (M), large (L)");
    }

    //MODIFIES: this
    //EFFECTS: allows for customers to add items into cart
    public void addItem() {
        System.out.println("Enter the item that you want to remove: \nhoodie, cap, beanie, totebag");
        String itemName = scanner.nextLine();
        if (!isItemName(itemName)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        System.out.println("Select Colour: white or black");
        String itemColour = scanner.nextLine();
        if (!isColourName(itemColour)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        System.out.println("Select size: S, M, L");
        String itemSize = scanner.nextLine();
        if (!isSizeName(itemSize)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        Clothing item = new Clothing(itemName, itemColour, itemSize);
        customer.addToCart(new Clothing(itemName, itemColour, itemSize));
        System.out.println("Added to cart!");
    }

    private boolean isItemName(String itemName) {
        return itemName.equals("hoodie") || itemName.equals("cap")
                || itemName.equals("beanie") || itemName.equals("totebag");
    }

    private boolean isColourName(String colourName) {
        return colourName.equals("white") || colourName.equals("black");
    }

    private boolean isSizeName(String sizeName) {
        return sizeName.equals("S") || sizeName.equals("M") || sizeName.equals("L");
    }

    //MODIFIES: this
    //EFFECTS: allows for customers to remove items into cart
    @SuppressWarnings("methodlength")
    public void removeItem() {
        System.out.println("Enter the item that you want to remove: \nhoodie, cap, beanie, totebag");
        String itemName = scanner.nextLine();
        if (!isItemName(itemName)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        System.out.println("Select Colour: white or black");
        String itemColour = scanner.nextLine();
        if (!isColourName(itemColour)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        System.out.println("Select size: S, M, L");
        String itemSize = scanner.nextLine();
        if (!isSizeName(itemSize)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        Clothing itemToRemove = findItem(itemName, itemColour, itemSize);
        if (itemToRemove != null) {
            customer.removeInCart(itemToRemove);
            System.out.println("Removed from cart!");
        } else {
            System.out.println("Item not found.");
        }
    }

    //EFFECTS: finds clothing item in cart
    private Clothing findItem(String itemName, String itemColour, String itemSize) {
        for (Clothing item : customer.viewCart()) {
            if (item.getNameOfItem().equals(itemName) && item.getColour().equals(itemColour)
                    && item.getSize().equals(itemSize)) {
                return item;
            }
        }
        return null;
    }


    public void viewCart() {
        System.out.println("Items in cart: ");
        if (customer.cartIsEmpty()) {
            System.out.println("Your cart is empty!");
        }
        for (Clothing item : customer.viewCart()) {
            System.out.println(item.getNameOfItem() + "(" + item.getColour() + ")"
                    + "  size:" + item.getSize() + "   $" + item.getPrice());
        }
        customer.viewCartPage();
    }

    public void getTotal() {
        System.out.println("Total amount: $" + customer.getTotal());
    }

    //MODIFIES: this
    //EFFECTS: allows customer to order item, once ordered cart is cleared
    public void orderItems() {
        if (customer.cartIsEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            System.out.println("Your total is $" + customer.getTotal());
            System.out.println("Press Y to confirm, N to return");
            String reply = scanner.nextLine();
            if (reply.equals("Y")) {
                System.out.println("Thank you for your order");
                customer.emptyCart();
            } else if (reply.equals("N")) {
                System.out.println("Continue Shopping");
            } else {
                System.out.println("Invalid Option");
            }
        }
    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: saves the workroom to file
    private void saveWorkRoom() {
        try {
            jsonWriter.open();
            jsonWriter.write(customer);
            jsonWriter.close();
            System.out.println("Saved " + customer.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadWorkRoom() {
        try {
            customer = jsonReader.readCustomer();
            System.out.println("Loaded " + customer.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}

