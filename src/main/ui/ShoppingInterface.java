package ui;

import java.util.Scanner;
import java.util.List;

import model.Customer;
import model.Clothing;

public class ShoppingInterface {
    private Customer customer;
    private Scanner scanner;

    public ShoppingInterface(Customer customer) {
        this.customer = customer;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to my store!");
        System.out.println("1. View Catalogue");
        System.out.println("2. Add Item");
        System.out.println("3. Remove Item");
        System.out.println("4. View Cart");
        System.out.println("5. Get Total");
        System.out.println("6. Order Items");
        System.out.println("7. Exit");
    }

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
                    shopping = false;
                    System.out.println("Thank you for shopping!");
                    break;
                case 8:
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    public void viewCatalogue() {
        System.out.println("Hoodies $50, Caps $15, Beanies $15, Totebags $10");
        System.out.println("Each item comes in either black or white");
        System.out.println("Each item is sized from small (S), medium (M), large (L)");
    }

    public void addItem() {
        System.out.println("Enter the item that you want to add: ");
        System.out.println("hoodie, cap, beanie, totebag ");
        String itemName = scanner.nextLine();
        ;
        if (!isItemName(itemName)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        System.out.println("Select Colour: white or black");
        String itemColour = scanner.nextLine();
        ;
        if (!isColourName(itemColour)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        System.out.println("Select size: S, M, L");
        char itemSize = scanner.nextLine().charAt(0);
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

    private boolean isSizeName(char sizeName) {
        return sizeName == 'S' || sizeName == 'M' || sizeName == 'L';
    }


    public void removeItem() {
        System.out.println("Enter the item that you want to remove: ");
        System.out.println("hoodie, cap, beanie, totebag ");
        String itemName = scanner.nextLine();
        ;
        if (!isItemName(itemName)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        System.out.println("Select Colour: white or black");
        String itemColour = scanner.nextLine();
        ;
        if (!isColourName(itemColour)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        System.out.println("Select size: S, M, L");
        char itemSize = scanner.nextLine().charAt(0);
        if (!isSizeName(itemSize)) {
            System.out.println("Invalid name, please try again.");
            return;
        }
        Clothing itemToRemove = null;
        for (Clothing item : customer.viewCart()) {
            if (item.getNameOfItem().equals(itemName) && item.getColour().equals(itemColour)
                    && item.getSize() == itemSize) {
                itemToRemove = item;
            }
        }
        if (itemToRemove != null) {
            customer.removeInCart(itemToRemove);
            System.out.println("Removed from cart!");
        } else {
            System.out.println("Item not found.");
        }
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
    }

    public void getTotal() {
        System.out.println("Total amount: $" + customer.getTotal());
    }

    public void orderItems() {
        if (customer.cartIsEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            System.out.println("Would you like to submit your order?");
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
}

