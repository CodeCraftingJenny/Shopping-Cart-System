package ui;

import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends JFrame {

    private static JComboBox<String> sizeComboBox;
    private static JComboBox<String> colourComboBox;
    private static Customer customer = new Customer("JJ");
    private static List<String> cartMessages = new ArrayList<>();
    private static double totalPrice = 0.0;
    private static List<Double> itemPrices = new ArrayList<>();
    private static JTextField indexField;
    private static JTextField nameField;
    private static JTextField addressField;
    private static JTextField phoneField;
    private static JTextField emailField;


    private static ImageIcon resizeImage(String imagePath, int width, int height) {

        ImageIcon originalIcon = new ImageIcon(MainMenu.class.getResource(imagePath));
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    private static JComboBox<String> createSizeComboBox() {
        String[] sizes = {"Small", "Medium", "Large"};
        sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.setBounds(550, 200, 100, 30);
        return sizeComboBox;
    }

    private static JComboBox<String> createColourComboBox() {
        String[] colours = {"White", "Black"};
        colourComboBox = new JComboBox<>(colours);
        colourComboBox.setBounds(675, 200, 100, 30);
        return colourComboBox;
    }

    private static JLabel hatPrice() {
        JLabel priceHat = new JLabel();
        priceHat.setText("$15.00");
        priceHat.setBounds(650, 300, 50, 30);
        priceHat.setVisible(true);
        return priceHat;
    }

    private static JLabel hoodiePrice() {
        JLabel priceHoodie = new JLabel();
        priceHoodie.setText("$50.00");
        priceHoodie.setBounds(650, 300, 50, 30);
        priceHoodie.setVisible(true);
        return priceHoodie;
    }

    private static JLabel totePrice() {
        JLabel priceBag = new JLabel();
        priceBag.setText("$10.00");
        priceBag.setBounds(650, 300, 50, 30);
        priceBag.setVisible(true);
        return priceBag;
    }


    private static JLabel displayMessages() {
        StringBuilder messageBuilder = new StringBuilder();
        for (String message : cartMessages) {
            messageBuilder.append(message).append("<br>");
        }
        String allMessages = "<html>" + messageBuilder.toString() + "<html>";
        JLabel messageLabel = new JLabel(allMessages);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        messageLabel.setVerticalAlignment(SwingConstants.TOP);
        messageLabel.setPreferredSize(new Dimension(400, 500));

        return messageLabel;
    }

    private static JLabel displayTotalPrice() {
        JLabel totalLabel = new JLabel("Total Price: $" + totalPrice);
        return totalLabel;
    }

    private static JButton createHoodieButton() {
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

    private static JButton createCapButton() {
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

    private static JButton createToteBagButton() {
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

    private static JButton createBeanieButton() {
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

    protected static JButton createWhiteBeanieButton(JLabel whiteBeanie, JLabel blackBeanie) {
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


    private static JButton createShoppingCartButton() {
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


    protected static JButton createWhiteHoodieButton(JLabel whiteHoodie, JLabel blackHoodie) {
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

    protected static JButton createBlackHoodieButton(JLabel whiteHoodie, JLabel blackHoodie) {
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

    private static JButton createAddToCartButton(String itemName, double price) {
        JButton cart = new JButton("Add Cart");
        cart.setBounds(550, 300, 85, 30);
        cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = itemName + " - " + colourComboBox.getSelectedItem() + " - " + sizeComboBox.getSelectedItem() + " - $" + price;
                addToCart(selectedItem, price);
            }
        });
        return cart;
    }

    protected static JButton createWhiteCapButton(JLabel whiteCap, JLabel blackCap) {
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

    protected static JButton createBlackCapButton(JLabel whiteCap, JLabel blackCap) {
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

    protected static JButton createWhiteToteButton(JLabel whiteTote, JLabel blackTote) {
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

    protected static JButton createBlackToteButton(JLabel whiteTote, JLabel blackTote) {
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


    protected static JButton createBlackBeanieButton(JLabel whiteBeanie, JLabel blackBeanie) {
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

    private static JButton orderItem() {
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



    private static void addToCart(String selectedItem, double price) {
        String message = selectedItem + " added to cart";
        cartMessages.add(message);
        JOptionPane.showMessageDialog(null, message);
        itemPrices.add(price);
        totalPrice += price;
    }

    private static void removeFromCart(int index) {
        if (index >= 0 && index < cartMessages.size()) {
            String removeItem = cartMessages.remove(index);
            double removePrice = itemPrices.remove(index);
            totalPrice -= removePrice;
            JOptionPane.showMessageDialog(null, removeItem + " has been removed");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid");
        }
    }

    protected static void openCapFrame() {
        JFrame capFrame = new JFrame("Cap Frame");
        capFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        capFrame.setSize(1000, 700);
        capFrame.setLocationRelativeTo(null);
        capFrame.setLayout(null);
        capFrame.setVisible(true);

        ImageIcon whiteCap = resizeImage("whiteCap.png", 250, 200);
        JLabel wCap = new JLabel();
        wCap.setIcon(whiteCap);
        wCap.setBounds(150, 100, 300, 300);
        wCap.setVisible(false);

        ImageIcon blackCap = resizeImage("blackCap.png", 250, 200);
        JLabel bCap = new JLabel();
        bCap.setIcon(blackCap);
        bCap.setBounds(150, 100, 300, 300);
        bCap.setVisible(false);

        ImageIcon defaultCap = resizeImage("whiteCap.png", 250, 200);
        JLabel dCap = new JLabel();
        dCap.setIcon(whiteCap);
        dCap.setBounds(150, 100, 300, 300);
        dCap.setVisible(true);

        JButton whiteButton = createWhiteCapButton(wCap, bCap);
        JButton blackButton = createBlackCapButton(wCap, bCap);

        capFrame.add(wCap);
        capFrame.add(bCap);
        capFrame.add(dCap);
        capFrame.add(whiteButton);
        capFrame.add(blackButton);
        capFrame.add(createAddToCartButton("Cap", 15.00));
        capFrame.add(createSizeComboBox());
        capFrame.add(createColourComboBox());
        capFrame.add(hatPrice());
    }

    protected static void openHoodieFrame() {
        JFrame hoodieFrame = new JFrame("Hoodie Frame");
        hoodieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hoodieFrame.setSize(1000, 700);
        hoodieFrame.setLocationRelativeTo(null);
        hoodieFrame.setLayout(null);
        hoodieFrame.setVisible(true);

        ImageIcon newHoodie = resizeImage("hoodie.png", 500, 500);
        JLabel hoodie = new JLabel();
        hoodie.setIcon(newHoodie);
        hoodie.setBounds(50, 50, 500, 500);
        hoodie.setVisible(false);

        ImageIcon newBlackHoodie = resizeImage("blackhoodie.png", 500, 500);
        JLabel blackHoodie = new JLabel();
        blackHoodie.setIcon(newBlackHoodie);
        blackHoodie.setBounds(50, 50, 500, 500);
        blackHoodie.setVisible(false);

        ImageIcon defaultHoodie = resizeImage("hoodie.png", 500, 500);
        JLabel defHoodie = new JLabel();
        defHoodie.setIcon(newHoodie);
        defHoodie.setBounds(50, 50, 500, 500);
        defHoodie.setVisible(true);

        JButton whiteButton = createWhiteHoodieButton(hoodie, blackHoodie);
        JButton blackButton = createBlackHoodieButton(hoodie, blackHoodie);

        hoodieFrame.add(hoodie);
        hoodieFrame.add(blackHoodie);
        hoodieFrame.add(defHoodie);
        hoodieFrame.add(whiteButton);
        hoodieFrame.add(blackButton);
        hoodieFrame.add(createAddToCartButton("Hoodie", 50.00));
        hoodieFrame.add(createSizeComboBox());
        hoodieFrame.add(createColourComboBox());
        hoodieFrame.add(hoodiePrice());

    }

    protected static void openToteBagFrame() {
        JFrame toteBagFrame = new JFrame("Tote Bag Frame");
        toteBagFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        toteBagFrame.setSize(1000, 700);
        toteBagFrame.setLocationRelativeTo(null);
        toteBagFrame.setLayout(null);
        toteBagFrame.setVisible(true);

        ImageIcon whiteToteBag = resizeImage("wTote.png", 400, 300);
        JLabel wTote = new JLabel();
        wTote.setIcon(whiteToteBag);
        wTote.setBounds(150, 100, 400, 400);
        wTote.setVisible(false);

        ImageIcon blackToteBag = resizeImage("bTote.png", 400, 300);
        JLabel bTote = new JLabel();
        bTote.setIcon(blackToteBag);
        bTote.setBounds(150, 100, 400, 400);
        bTote.setVisible(false);

        ImageIcon defaultTote = resizeImage("wTote.png", 400, 300);
        JLabel dTote = new JLabel();
        dTote.setIcon(whiteToteBag);
        dTote.setBounds(150, 100, 400, 400);
        dTote.setVisible(true);

        JButton whiteButton = createWhiteToteButton(wTote, bTote);
        JButton blackButton = createBlackToteButton(wTote, bTote);

        toteBagFrame.add(wTote);
        toteBagFrame.add(bTote);
        toteBagFrame.add(dTote);
        toteBagFrame.add(whiteButton);
        toteBagFrame.add(blackButton);
        toteBagFrame.add(createAddToCartButton("Tote bag", 10.00));
        toteBagFrame.add(createSizeComboBox());
        toteBagFrame.add(createColourComboBox());
        toteBagFrame.add(totePrice());
    }

    protected static void openBeanieFrame() {
        JFrame beanieFrame = new JFrame("Beanie Frame");
        beanieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        beanieFrame.setSize(1000, 700);
        beanieFrame.setLocationRelativeTo(null);
        beanieFrame.setLayout(null);
        beanieFrame.setVisible(true);

        ImageIcon whiteBeanie = resizeImage("wBeanie.png", 400, 300);
        JLabel wBeanie = new JLabel();
        wBeanie.setIcon(whiteBeanie);
        wBeanie.setBounds(125, 50, 400, 400);
        wBeanie.setVisible(false);

        ImageIcon blackBeanie = resizeImage("bBeanie.png", 400, 300);
        JLabel bBeanie = new JLabel();
        bBeanie.setIcon(blackBeanie);
        bBeanie.setBounds(125, 50, 400, 400);
        bBeanie.setVisible(false);

        ImageIcon defaultTote = resizeImage("wBeanie.png", 400, 300);
        JLabel dBeanie = new JLabel();
        wBeanie.setIcon(whiteBeanie);
        wBeanie.setBounds(125, 50, 400, 400);
        wBeanie.setVisible(true);

        JButton whiteButton = createWhiteBeanieButton(wBeanie, bBeanie);
        JButton blackButton = createBlackBeanieButton(wBeanie, bBeanie);

        beanieFrame.add(wBeanie);
        beanieFrame.add(bBeanie);
        beanieFrame.add(dBeanie);
        beanieFrame.add(whiteButton);
        beanieFrame.add(blackButton);
        beanieFrame.add(createAddToCartButton("Beanie", 15.00));
        beanieFrame.add(createSizeComboBox());
        beanieFrame.add(createColourComboBox());
        beanieFrame.add(hatPrice());
    }


    protected static void openCartFrame() {
        JFrame cartFrame = new JFrame("Cart Frame");
        cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cartFrame.setSize(1000, 700);
        cartFrame.setLocationRelativeTo(null);
        cartFrame.setLayout(null);
        cartFrame.setVisible(true);
        JLabel indexLabel = new JLabel("Enter index of item you want removed: ");
        indexField = new JTextField(2);
        indexLabel.setBounds(700, 200, 250, 30);
        indexField.setBounds(700, 240, 100, 30);
        cartFrame.add(indexField);

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String indexString = indexField.getText();
                int indexInt = Integer.parseInt(indexString) - 1;
                removeFromCart(indexInt);
            }
        });
        removeButton.setBounds(700, 300, 100, 30);

        JLabel messageLabel = displayMessages();
        messageLabel.setBounds(300, 50, 400, 500);
        cartFrame.add(messageLabel);

        JLabel totalPriceLabel = displayTotalPrice();
        totalPriceLabel.setBounds(700, 350, 200, 30);
        cartFrame.add(totalPriceLabel);
        cartFrame.add(orderItem());
        cartFrame.add(indexLabel);
        cartFrame.add(removeButton);
    }

    public static void menuGUI() {
        ImageIcon newHoodie = resizeImage("hoodie.png", 150, 150);
        JLabel hoodie = new JLabel();
        hoodie.setIcon(newHoodie);
        hoodie.setBounds(200, 50, 300, 300);

        ImageIcon newCap = resizeImage("cap.png", 150, 100);
        JLabel cap = new JLabel();
        cap.setIcon(newCap);
        cap.setBounds(600, 50, 300, 300);

        ImageIcon newToteBag = resizeImage("totebag.png", 150, 150);
        JLabel toteBag = new JLabel();
        toteBag.setIcon(newToteBag);
        toteBag.setBounds(200, 300, 300, 300);

        ImageIcon newBeanie = resizeImage("beanie.png", 150, 150);
        JLabel beanie = new JLabel();
        beanie.setIcon(newBeanie);
        beanie.setBounds(600, 300, 300, 300);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(hoodie);
        frame.add(cap);
        frame.add(toteBag);
        frame.add(beanie);

        frame.add(createHoodieButton());
        frame.add(createCapButton());
        frame.add(createToteBagButton());
        frame.add(createBeanieButton());

        JLabel welcome = new JLabel("Welcome");
        welcome.setFont(new Font("Arial", Font.BOLD, 30));
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setBounds(0, 50, frame.getWidth(), 30);
        frame.add(welcome);

        frame.add(createShoppingCartButton());

    }


    private static void orderFrame() {
        JFrame orderFrame = new JFrame("Order Frame");
        orderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        orderFrame.setSize(1000, 700);
        orderFrame.setLocationRelativeTo(null);
        orderFrame.setLayout(null);
        orderFrame.setVisible(true);
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

        emailField = new JTextField(2);
        emailField.setBounds(100, 400, 500, 30);
        orderFrame.add(emailField);
        JLabel emailLabel = new JLabel("Enter your email: ");
        emailLabel.setBounds(100, 350, 300, 30);
        orderFrame.add(emailLabel);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cartMessages.size() > 0) {
                    cartMessages.clear();
                    JOptionPane.showMessageDialog(null, "Order has been placed.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cart is empty");
                }
            }
        });
        confirmButton.setBounds(700, 300, 100, 30);
        orderFrame.add(confirmButton);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                menuGUI();
            }
        });
    }
}

