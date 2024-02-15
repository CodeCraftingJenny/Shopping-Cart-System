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
        System.out.println("1. Black Hoodie in Size S");
        System.out.println("2. Black Hoodie in Size M");
        System.out.println("3. Black Hoodie in Size L");
        System.out.println("4. White Hoodie in Size S");
        System.out.println("5. White Hoodie in Size M");
        System.out.println("6. White Hoodie in Size L");


        System.out.println("7. Black Cap in Size S");
        System.out.println("8. Black Cap in Size M");
        System.out.println("9. White Cap in Size S");
        System.out.println("10. White Cap in Size M");


        System.out.println("11. Black beanie in Size S");
        System.out.println("12. Black beanie in Size M");
        System.out.println("13. White beanie in Size S");
        System.out.println("14. White beanie in Size M");


        System.out.println("15. White Totebag in Size M");
        System.out.println("16. White Totebag in Size L");
        System.out.println("17. Black Totebag in Size M");
        System.out.println("18. Black Totebag in Size L");
    }

    public void addItem() {
        System.out.println("Enter the item that you want to add: ");
        System.out.println("hoodie, cap, beanie, totebag ");
        String itemName = scanner.nextLine();;
        System.out.println("Select Colour: white or black");
        String itemColour = scanner.nextLine();;
        System.out.println("Select size: S, M, L");
        char itemSize = scanner.nextLine().charAt(0);
        Clothing item = new Clothing(itemName, itemColour, itemSize);
        customer.addToCart(new Clothing(itemName, itemColour, itemSize));
        System.out.println("Added to cart!");
    }

    public void removeItem() {
        System.out.println("Enter the item that you want to remove: ");
        System.out.println("hoodie, cap, beanie, totebag ");
        String itemName = scanner.nextLine();;
        System.out.println("Select Colour: white or black");
        String itemColour = scanner.nextLine();;
        System.out.println("Select size: S, M, L");
        char itemSize = scanner.nextLine().charAt(0);
        Clothing itemToRemove = null;
        for (Clothing item : customer.viewCart()) {
            if (item.getNameOfItem().equals(itemName)
                    && item.getColour().equals(itemColour)
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

    public void viewCart()  {
        System.out.println("Items in cart: ");
        if (customer.cartIsEmpty()) {
            System.out.println("Your cart is empty!");
        }
         for (Clothing item : customer.viewCart()) {
            System.out.println(item.getNameOfItem() + " -- $" + item.getPrice());
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
            } else if (reply.equals("N")) {
                System.out.println("Continue Shopping");
            } else {
                System.out.println("Invalid Option");
            }
        }
    }
}

