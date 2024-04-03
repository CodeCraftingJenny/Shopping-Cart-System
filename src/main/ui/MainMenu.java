package ui;

import model.Clothing;
import model.Customer;
import model.Event;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends JFrame {

    private JComboBox<String> sizeComboBox;
    private JComboBox<String> colourComboBox;
    private double totalPrice = 0.0;
    private List<Double> itemPrices = new ArrayList<>();
    private JTextField indexField;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField emailField;
    private final String dataFile = "./data/customer.json";
    private Customer customer;

    //EFFECTS: Constructor that creates a customer and the menuGUI
    public MainMenu() {
        customer = new Customer("JJ");
        menuGUI();
    }

    //REQUIRES: Non-empty string that represents the image path to image, ints of width and height
    //MODIFIES: this
    //EFFECTS: loads image, resizes image, and returns that new image
    private ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(MainMenu.class.getResource(imagePath));
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    //EFFECTS: creates a combo box where the user can choose a size
    private JComboBox<String> createSizeComboBox() {
        String[] sizes = {"S", "M", "L"};
        sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.setBounds(550, 200, 100, 30);
        return sizeComboBox;
    }

    //EFFECTS: creates a combo box where the user can choose a colour
    private JComboBox<String> createColourComboBox() {
        String[] colours = {"white", "black"};
        colourComboBox = new JComboBox<>(colours);
        colourComboBox.setBounds(675, 200, 100, 30);
        return colourComboBox;
    }

    //EFFECTS: creates a label of hat price
    private JLabel hatPrice() {
        JLabel priceHat = new JLabel();
        priceHat.setText("$15.00");
        priceHat.setBounds(650, 300, 50, 30);
        priceHat.setVisible(true);
        return priceHat;
    }

    //EFFECTS: creates a label of hoodie price
    private JLabel hoodiePrice() {
        JLabel priceHoodie = new JLabel();
        priceHoodie.setText("$50.00");
        priceHoodie.setBounds(650, 300, 50, 30);
        priceHoodie.setVisible(true);
        return priceHoodie;
    }

    //EFFECTS: creates a label of tote price
    private JLabel totePrice() {
        JLabel priceBag = new JLabel();
        priceBag.setText("$10.00");
        priceBag.setBounds(650, 300, 50, 30);
        priceBag.setVisible(true);
        return priceBag;
    }

    //Citation: https://stackoverflow.com/questions/1090098/newline-in-jlabel
    //MODIFIES: this
    //EFFECTS: iterates over the items in the cart, creates a string that appends each item in cart
    // modifies the message so that it fits in the screen, returns the message
    private JLabel displayMessages() {
        StringBuilder messageBuilder = new StringBuilder("<html>");
        for (Clothing clothing : customer.viewCart()) {
            messageBuilder.append(clothing.getNameOfItem()).append(" - ")
                    .append(clothing.getColour()).append(" - ")
                    .append(clothing.getSize()).append(" - $")
                    .append(clothing.getPrice()).append("<br>");
        }
        messageBuilder.append("</html>");
        JLabel messageLabel = new JLabel();
        messageLabel.setText(messageBuilder.toString());
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        messageLabel.setVerticalAlignment(SwingConstants.TOP);
        messageLabel.setPreferredSize(new Dimension(400, 500));

        return messageLabel;
    }

    //EFFECTS: creates a label of total price
    private JLabel displayTotalPrice() {
        JLabel totalLabel = new JLabel("Total Price: $" + customer.getTotal());
        return totalLabel;
    }

    //EFFECTS: creates a hoodie button, if pressed it will open hoodie frame
    private JButton createHoodieButton() {
        JButton hoodieButton = new JButton("Hoodie");
        hoodieButton.setBounds(175, 270, 200, 30);
        hoodieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openHoodieFrame();
            }
        });
        return hoodieButton;
    }

    //EFFECTS: creates a cap button,if pressed it will open cap frame
    private JButton createCapButton() {
        JButton capButton = new JButton("Cap");
        capButton.setBounds(575, 270, 200, 30);
        capButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCapFrame();
            }
        });
        return capButton;
    }

    //EFFECTS: creates a tote bag button, if pressed it will open tote bag frame
    private JButton createToteBagButton() {
        JButton toteBag = new JButton("Tote Bag");
        toteBag.setBounds(175, 530, 200, 30);
        toteBag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openToteBagFrame();
            }
        });
        return toteBag;
    }

    //EFFECTS: creates a beanie button, if pressed it will open beanie frame
    private JButton createBeanieButton() {
        JButton beanie = new JButton("Beanie");
        beanie.setBounds(575, 530, 200, 30);
        beanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openBeanieFrame();
            }
        });
        return beanie;
    }

    //REQUIRES: two jlabels of white and black beanie
    //MODIFIES: black and white beanie
    //EFFECTS: creates a white button for beanie, if pressed it sets the white beanie visibility to true
    private JButton createWhiteBeanieButton(JLabel whiteBeanie, JLabel blackBeanie) {
        JButton whiteButton = new JButton("White");
        whiteButton.setBounds(550, 100, 70, 30);
        whiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == whiteButton) {
                    whiteBeanie.setVisible(true);
                    blackBeanie.setVisible(false);
                }
            }
        });
        return whiteButton;
    }

    //EFFECTS: creates a shopping cart button on the main page, if pressed it will open cart frame
    private JButton createShoppingCartButton() {
        JButton cart = new JButton("Cart");
        cart.setBounds(875, 30, 70, 30);
        cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCartFrame();
            }
        });
        return cart;
    }

    //EFFECTS: creates a exit button on the main page, if pressed it will close the program
    // once program is closed, a event log of actions will be returned
    private JButton createExitButton() {
        JButton exit = new JButton("Exit");
        exit.setBounds(775, 30, 70, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Event event : EventLog.getInstance()) {
                    System.out.println(event.toString() + "\n");
                }
                System.exit(0);
            }
        });
        return exit;
    }

    //REQUIRES: two jlabels of white and black hoodie
    //MODIFIES: black and white hoodie
    //EFFECTS: creates a white button for hoodie, if pressed it sets the white hoodie visibility to true
    private JButton createWhiteHoodieButton(JLabel whiteHoodie, JLabel blackHoodie) {
        JButton whiteButton = new JButton("White");
        whiteButton.setBounds(550, 100, 70, 30);
        whiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == whiteButton) {
                    whiteHoodie.setVisible(true);
                    blackHoodie.setVisible(false);
                }
            }
        });
        return whiteButton;
    }

    //REQUIRES: two jlabels of white and black hoodie
    //MODIFIES: black and white hoodie
    //EFFECTS: creates a black button for hoodie, if pressed it sets the black hoodie visibility to true
    private JButton createBlackHoodieButton(JLabel whiteHoodie, JLabel blackHoodie) {
        JButton blackButton = new JButton("Black");
        blackButton.setBounds(650, 100, 70, 30);
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == blackButton) {
                    blackHoodie.setVisible(true);
                    whiteHoodie.setVisible(false);
                }
            }
        });
        return blackButton;
    }

    //MODIFIES: customer, itemPrices, totalPrice
    //EFFECTS: adds clothing item to cart, also adds total prices
    private void addToCart(String selectedItem, String colour, String size) {
        Clothing clothing = new Clothing(selectedItem, colour, size);
        String message = selectedItem + " added to cart";
        customer.addToCart(clothing);
        JOptionPane.showMessageDialog(null, message);
        itemPrices.add(clothing.getPrice());
        totalPrice += clothing.getPrice();
    }

    //REQUIRES: clothing item, price of item
    //EFFECTS: Creates button to add items to cart, if pressed, item will be added to cart
    private JButton createAddToCartButton(Clothing itemName, double price) {
        JButton cart = new JButton("Add Cart");
        cart.setBounds(550, 300, 85, 30);
        cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart(itemName.getNameOfItem(),
                        (String) colourComboBox.getSelectedItem(), (String) sizeComboBox.getSelectedItem());
            }
        });
        return cart;
    }

    //REQUIRES: two jlabels of white and black cap
    //MODIFIES: black and white cap
    //EFFECTS: creates a white button for cap, if pressed it sets the white cap visibility to true
    private JButton createWhiteCapButton(JLabel whiteCap, JLabel blackCap) {
        JButton whiteButton = new JButton("White");
        whiteButton.setBounds(550, 100, 70, 30);
        whiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == whiteButton) {
                    whiteCap.setVisible(true);
                    blackCap.setVisible(false);
                }
            }
        });
        return whiteButton;
    }

    //REQUIRES: two jlabels of white and black cap
    //MODIFIES: black and white cap
    //EFFECTS: createss a black button for cap, if pressed it sets the black cap visbility to true
    private JButton createBlackCapButton(JLabel whiteCap, JLabel blackCap) {
        JButton blackButton = new JButton("Black");
        blackButton.setBounds(650, 100, 70, 30);
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == blackButton) {
                    blackCap.setVisible(true);
                    whiteCap.setVisible(false);
                }
            }
        });
        return blackButton;
    }

    //REQUIRES: two jlabels of white and black tote bag
    //MODIFIES: black and white totebag
    //EFFECTS: creates a white button for totebag, if pressed it sets the white totebag visibility to true
    private JButton createWhiteToteButton(JLabel whiteTote, JLabel blackTote) {
        JButton whiteButton = new JButton("White");
        whiteButton.setBounds(550, 100, 70, 30);
        whiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == whiteButton) {
                    whiteTote.setVisible(true);
                    blackTote.setVisible(false);
                }
            }
        });
        return whiteButton;
    }

    //REQUIRES: two jlabels of white and black tote bag
    //MODIFIES: black and white totebag
    //EFFECTS: creates a black button for totebag, if pressed it sets the black totebag visibility to true
    private JButton createBlackToteButton(JLabel whiteTote, JLabel blackTote) {
        JButton blackButton = new JButton("Black");
        blackButton.setBounds(650, 100, 70, 30);
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == blackButton) {
                    blackTote.setVisible(true);
                    whiteTote.setVisible(false);
                }
            }
        });
        return blackButton;
    }


    //REQUIRES: two jlabels of white and black beanie
    //MODIFIES: black and white beanie
    //EFFECTS: createss a black button for beanie, if pressed it sets the black beanie visbility to true
    private JButton createBlackBeanieButton(JLabel whiteBeanie, JLabel blackBeanie) {
        JButton blackButton = new JButton("Black");
        blackButton.setBounds(650, 100, 70, 30);
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == blackButton) {
                    blackBeanie.setVisible(true);
                    whiteBeanie.setVisible(false);
                }
            }
        });
        return blackButton;
    }

    //EFFECTS: creates a button where customers can order item, if pressed, it will open the order frame
    private JButton orderItem() {
        JButton order = new JButton("Order Items");
        order.setBounds(700, 400, 120, 30);
        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderFrame();
            }
        });
        return order;
    }

    //EFFECTS: creates a button where user can save what's in their cart
    private JButton saveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(700, 450, 100, 30);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCart();
                JOptionPane.showMessageDialog(null, "Your cart has been saved");
            }
        });
        return saveButton;
    }

    //EFFECTS: creates a button where user can load what's in their cart
    private JButton loadButton() {
        JButton loadButton = new JButton("Load");
        loadButton.setBounds(820, 450, 100, 30);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadCart();
                JOptionPane.showMessageDialog(null, "Your cart has been loaded, please open cart again.");
            }
        });
        return loadButton;
    }


    //MODIFIES: this
    //EFFECTS: opens a frame of the cap item with all of its features
    private void openCapFrame() {
        JFrame capFrame = setUpFrame("Cap Frame");
        ImageIcon whiteCap = resizeImage("whiteCap.png", 250, 200);
        JLabel capWhite = getCapWhite(whiteCap);
        JLabel capBlack = getCapBlack();
        JLabel defCap = getDefCap(whiteCap);
        JButton whiteButton = createWhiteCapButton(capWhite, capBlack);
        JButton blackButton = createBlackCapButton(capWhite, capBlack);
        capFrame.add(createSizeComboBox());
        capFrame.add(createColourComboBox());
        capFrame.add(capWhite);
        capFrame.add(capBlack);
        capFrame.add(defCap);
        capFrame.add(whiteButton);
        capFrame.add(blackButton);
        Clothing cap = new Clothing("cap",
                (String) colourComboBox.getSelectedItem(), (String) sizeComboBox.getSelectedItem());
        capFrame.add(createAddToCartButton(cap, 15.00));
        capFrame.add(hatPrice());
    }

    //EFFECTS: creates a label of a white cap
    private JLabel getCapWhite(ImageIcon whiteCap) {
        JLabel capWhite = new JLabel();
        capWhite.setIcon(whiteCap);
        capWhite.setBounds(150, 100, 300, 300);
        capWhite.setVisible(false);
        return capWhite;
    }

    //EFFECTS: creates a label of a black cap
    private JLabel getCapBlack() {
        ImageIcon blackCap = resizeImage("blackCap.png", 250, 200);
        JLabel capBlack = new JLabel();
        capBlack.setIcon(blackCap);
        capBlack.setBounds(150, 100, 300, 300);
        capBlack.setVisible(false);
        return capBlack;
    }

    //EFFECTS: creates a label of a default white cap
    private JLabel getDefCap(ImageIcon whiteCap) {
        ImageIcon defaultCap = resizeImage("whiteCap.png", 250, 200);
        JLabel defCap = new JLabel();
        defCap.setIcon(whiteCap);
        defCap.setBounds(150, 100, 300, 300);
        defCap.setVisible(true);
        return defCap;
    }

    //MODIFIES: this
    //EFFECTS: opens a frame of the hoodie item with all of its features
    private void openHoodieFrame() {
        JFrame hoodieFrame = setUpFrame("Hoodie Frame");
        ImageIcon newHoodie = resizeImage("hoodie.png", 500, 500);
        JLabel hoodie = new JLabel();
        hoodie.setIcon(newHoodie);
        hoodie.setBounds(50, 50, 500, 500);
        hoodie.setVisible(false);
        JLabel blackHoodie = getBlackHoodie();
        JLabel defHoodie = getDefHoodie(newHoodie);
        JButton whiteButton = createWhiteHoodieButton(hoodie, blackHoodie);
        JButton blackButton = createBlackHoodieButton(hoodie, blackHoodie);
        hoodieFrame.add(createSizeComboBox());
        hoodieFrame.add(createColourComboBox());
        hoodieFrame.add(hoodie);
        hoodieFrame.add(blackHoodie);
        hoodieFrame.add(defHoodie);
        hoodieFrame.add(whiteButton);
        hoodieFrame.add(blackButton);
        Clothing hoodieClothing = new Clothing("hoodie",
                (String) colourComboBox.getSelectedItem(), (String) sizeComboBox.getSelectedItem());
        hoodieFrame.add(createAddToCartButton(hoodieClothing, 50.00));
        hoodieFrame.add(hoodiePrice());
    }

    //EFFECTS: creates a label of a default white hoodie
    private JLabel getDefHoodie(ImageIcon newHoodie) {
        ImageIcon defaultHoodie = resizeImage("hoodie.png", 500, 500);
        JLabel defHoodie = new JLabel();
        defHoodie.setIcon(newHoodie);
        defHoodie.setBounds(50, 50, 500, 500);
        defHoodie.setVisible(true);
        return defHoodie;
    }

    //EFFECTS: creates a label of a black hoodie
    private JLabel getBlackHoodie() {
        ImageIcon newBlackHoodie = resizeImage("blackhoodie.png", 500, 500);
        JLabel blackHoodie = new JLabel();
        blackHoodie.setIcon(newBlackHoodie);
        blackHoodie.setBounds(50, 50, 500, 500);
        blackHoodie.setVisible(false);
        return blackHoodie;
    }

    //MODIFIES: this
    //EFFECTS: creates a frame according to specifications
    private JFrame setUpFrame(String createFrame) {
        JFrame newFrame = new JFrame(createFrame);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setSize(1000, 700);
        newFrame.setLocationRelativeTo(null);
        newFrame.setLayout(null);
        newFrame.setVisible(true);
        return newFrame;
    }

    //MODIFIES: this
    //EFFECTS: opens a frame of the tote bag item with all of its features
    private void openToteBagFrame() {
        JFrame toteBagFrame = setUpFrame("Tote Bag Frame");
        ImageIcon whiteToteBag = resizeImage("wTote.png", 400, 300);
        JLabel whiteTote = new JLabel();
        whiteTote.setIcon(whiteToteBag);
        whiteTote.setBounds(150, 100, 400, 400);
        whiteTote.setVisible(false);
        JLabel blackTote = getBlackTote();
        JLabel defTote = getDefTote(whiteToteBag);
        JButton whiteButton = createWhiteToteButton(whiteTote, blackTote);
        JButton blackButton = createBlackToteButton(whiteTote, blackTote);
        toteBagFrame.add(createSizeComboBox());
        toteBagFrame.add(createColourComboBox());
        toteBagFrame.add(whiteTote);
        toteBagFrame.add(blackTote);
        toteBagFrame.add(defTote);
        toteBagFrame.add(whiteButton);
        toteBagFrame.add(blackButton);
        Clothing toteBag = new Clothing("totebag",
                (String) colourComboBox.getSelectedItem(), (String) sizeComboBox.getSelectedItem());
        toteBagFrame.add(createAddToCartButton(toteBag, 10.00));
        toteBagFrame.add(totePrice());
    }

    //EFFECTS: creates a label of a black tote bag
    private JLabel getBlackTote() {
        ImageIcon blackToteBag = resizeImage("bTote.png", 400, 300);
        JLabel blackTote = new JLabel();
        blackTote.setIcon(blackToteBag);
        blackTote.setBounds(150, 100, 400, 400);
        blackTote.setVisible(false);
        return blackTote;
    }

    //EFFECTS: creates a label of a white tote bag
    private JLabel getDefTote(ImageIcon whiteToteBag) {
        ImageIcon defaultTote = resizeImage("wTote.png", 400, 300);
        JLabel defTote = new JLabel();
        defTote.setIcon(whiteToteBag);
        defTote.setBounds(150, 100, 400, 400);
        defTote.setVisible(true);
        return defTote;
    }

    //MODIFIES: this
    //EFFECTS: opens a frame of the beanie item with all of its features
    private void openBeanieFrame() {
        JFrame beanieFrame = setUpFrame("Beanie Frame");

        ImageIcon whiteBeanie = resizeImage("wBeanie.png", 400, 300);
        JLabel beanieWhite = new JLabel();
        beanieWhite.setIcon(whiteBeanie);
        beanieWhite.setBounds(125, 50, 400, 400);
        beanieWhite.setVisible(false);

        JLabel beanieBlack = getBeanieBlack();

        JLabel defBeanie = getDefBeanie(whiteBeanie, beanieWhite);

        JButton whiteButton = createWhiteBeanieButton(beanieWhite, beanieBlack);
        JButton blackButton = createBlackBeanieButton(beanieWhite, beanieBlack);
        beanieFrame.add(createSizeComboBox());
        beanieFrame.add(createColourComboBox());
        beanieFrame.add(beanieWhite);
        beanieFrame.add(beanieBlack);
        beanieFrame.add(defBeanie);
        beanieFrame.add(whiteButton);
        beanieFrame.add(blackButton);
        Clothing beanie = new Clothing("beanie",
                (String) colourComboBox.getSelectedItem(), (String) sizeComboBox.getSelectedItem());
        beanieFrame.add(createAddToCartButton(beanie, 15.00));

        beanieFrame.add(hatPrice());
    }

    //EFFECTS: creates a label of a black beanie
    private JLabel getBeanieBlack() {
        ImageIcon blackBeanie = resizeImage("bBeanie.png", 400, 300);
        JLabel beanieBlack = new JLabel();
        beanieBlack.setIcon(blackBeanie);
        beanieBlack.setBounds(125, 50, 400, 400);
        beanieBlack.setVisible(false);
        return beanieBlack;
    }

    //EFFECTS: creates a label of a white beanie
    private JLabel getDefBeanie(ImageIcon whiteBeanie, JLabel beanieWhite) {
        ImageIcon defaultTote = resizeImage("wBeanie.png", 400, 300);
        JLabel defBeanie = new JLabel();
        beanieWhite.setIcon(whiteBeanie);
        beanieWhite.setBounds(125, 50, 400, 400);
        beanieWhite.setVisible(true);
        return defBeanie;
    }

    //MODIFIES: this
    //EFFECTS: opens a frame of the cart frame, where user can view what's in their cart
    // remove items, save, and load their cart
    private void openCartFrame() {
        customer.viewCartPage();

        JFrame cartFrame = setUpFrame("Cart Frame");
        JLabel indexLabel = new JLabel("Enter index of item you want removed: ");
        indexField = new JTextField(2);
        indexLabel.setBounds(700, 200, 250, 30);
        indexField.setBounds(700, 240, 100, 30);
        cartFrame.add(indexField);

        JButton removeButton = createRemoveButton();

        JLabel messageLabel = displayMessages();
        messageLabel.setBounds(300, 50, 400, 500);
        cartFrame.add(messageLabel);
        JLabel totalPriceLabel = displayTotalPrice();
        totalPriceLabel.setBounds(700, 350, 200, 30);
        cartFrame.add(totalPriceLabel);
        cartFrame.add(orderItem());
        cartFrame.add(indexLabel);
        cartFrame.add(removeButton);
        cartFrame.add(saveButton());
        cartFrame.add(loadButton());
    }

    //REQUIRES: index should not be negative
    //MODIFIES: this
    //EFFECTS: removes item in cart according to the given index
    private void removeFromCart(int index) {
        if (index >= 0 && index < customer.viewCart().size()) {
            Clothing removeItem = customer.viewCart().remove(index);
            customer.removeInCart(removeItem);
            double removePrice = itemPrices.remove(index);
            totalPrice -= removePrice;
            JOptionPane.showMessageDialog(null,
                    removeItem.getNameOfItem() + " has been removed. Please open cart again.");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid");
        }
    }

    //EFFECTS: Creates a remove button, if pressed, item will be removed
    private JButton createRemoveButton() {
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String indexString = indexField.getText();
                if (!indexString.isEmpty()) {
                    int indexInt = Integer.parseInt(indexString);
                    removeFromCart(indexInt - 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            }
        });
        removeButton.setBounds(700, 300, 100, 30);
        return removeButton;
    }

    //MODIFIES: this
    //EFFECTS: opens a frame of the menu with all of its features
    public void menuGUI() {
        JLabel hoodie = getHoodie();
        JLabel cap = getCap();
        JLabel toteBag = getToteBag();
        JLabel beanie = getBeanie();


        JFrame frame = setFrame();
        frame.add(hoodie);
        frame.add(cap);
        frame.add(toteBag);
        frame.add(beanie);

        frame.add(createHoodieButton());
        frame.add(createCapButton());
        frame.add(createToteBagButton());
        frame.add(createBeanieButton());

        JLabel welcome = getWelcomeLabel(frame);
        frame.add(welcome);

        frame.add(createShoppingCartButton());
        frame.add(createExitButton());
    }

    //EFFECTS: returns the hoodie image as a label
    private JLabel getHoodie() {
        ImageIcon newHoodie = resizeImage("hoodie.png", 150, 150);
        JLabel hoodie = new JLabel();
        hoodie.setIcon(newHoodie);
        hoodie.setBounds(200, 50, 300, 300);
        return hoodie;
    }

    //EFFECTS: returns the cap image as a label
    private JLabel getCap() {
        ImageIcon newCap = resizeImage("cap.png", 150, 100);
        JLabel cap = new JLabel();
        cap.setIcon(newCap);
        cap.setBounds(600, 50, 300, 300);
        return cap;
    }

    //EFFECTS: returns the tote bag image as a label
    private JLabel getToteBag() {
        ImageIcon newToteBag = resizeImage("totebag.png", 150, 150);
        JLabel toteBag = new JLabel();
        toteBag.setIcon(newToteBag);
        toteBag.setBounds(200, 300, 300, 300);
        return toteBag;
    }

    //EFFECTS: returns the beanie image as a label
    private JLabel getBeanie() {
        ImageIcon newBeanie = resizeImage("beanie.png", 150, 150);
        JLabel beanie = new JLabel();
        beanie.setIcon(newBeanie);
        beanie.setBounds(600, 300, 300, 300);
        return beanie;
    }

    //MODIFIES: this
    //EFFECTS: creates a JFrame
    private JFrame setFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(null);
        frame.setVisible(true);
        return frame;
    }

    //EFFECTS: creates a welcome label in main menu
    private JLabel getWelcomeLabel(JFrame frame) {
        JLabel welcome = new JLabel("Welcome");
        welcome.setFont(new Font("Arial", Font.BOLD, 30));
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setBounds(0, 50, frame.getWidth(), 30);
        return welcome;
    }

    //REQUIRES: nameField, addressField, and phoneField should not be empty
    //MODIFIES: this
    //EFFECTS: opens a frame of the order menu, where users can input their information
    private void orderFrame() {
        JFrame orderFrame = setUpFrame("Order Frame");
        nameField = new JTextField(2);
        nameField.setBounds(100, 100, 500, 30);
        orderFrame.add(nameField);
        JLabel nameLabel = new JLabel("Enter your full name: ");
        nameLabel.setBounds(100, 50, 300, 30);
        orderFrame.add(nameLabel);

        addressField = new JTextField(2);
        addressField.setBounds(100, 200, 500, 30);
        orderFrame.add(addressField);
        JLabel addressLabel = new JLabel("Enter your full address: ");
        addressLabel.setBounds(100, 150, 300, 30);
        orderFrame.add(addressLabel);

        phoneField = new JTextField(2);
        phoneField.setBounds(100, 300, 500, 30);
        orderFrame.add(phoneField);
        JLabel phoneLabel = new JLabel("Enter your phone number: ");
        phoneLabel.setBounds(100, 250, 300, 30);
        orderFrame.add(phoneLabel);

        JLabel emailLabel = getEmailLabel(orderFrame);
        orderFrame.add(emailLabel);

        JButton confirmButton = getConfirmButton();
        orderFrame.add(confirmButton);

    }

    //MODIFIES: this
    //EFFECTS: creates a label and a field where user can input their email
    private JLabel getEmailLabel(JFrame orderFrame) {
        emailField = new JTextField(2);
        emailField.setBounds(100, 400, 500, 30);
        orderFrame.add(emailField);
        JLabel emailLabel = new JLabel("Enter your email: ");
        emailLabel.setBounds(100, 350, 300, 30);
        return emailLabel;
    }

    //EFFECTS: creates a confirm button, if clicked cart will be emptied
    private JButton getConfirmButton() {
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customer.viewCart().size() > 0) {
                    customer.emptyCart();
                    JOptionPane.showMessageDialog(null, "Order has been placed.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cart is empty");
                }
            }
        });
        confirmButton.setBounds(700, 300, 100, 30);
        return confirmButton;
    }

    //MODIFIES: this
    //EFFECTS: saves cart into file
    private void saveCart() {
        JsonWriter jsonWriter = new JsonWriter(dataFile);
        try {
            jsonWriter.open();
            jsonWriter.write(customer);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads cart from file
    private void loadCart() {
        JsonReader jsonReader = new JsonReader(dataFile);
        try {
            customer = jsonReader.readCustomer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainMenu();
            }
        });
    }
}

