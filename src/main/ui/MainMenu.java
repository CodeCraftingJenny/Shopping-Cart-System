package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

private static boolean hoodieFrameOpened = false;

    private static ImageIcon resizeImage(String imagePath, int width, int height) {

        ImageIcon originalIcon = new ImageIcon(MainMenu.class.getResource(imagePath));
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH );
        return new ImageIcon(scaledImage);
    }

    private static JButton createHoodieButton() {
        JButton hoodieButton = new JButton("Hoodie");
        hoodieButton.setBounds(175, 270, 200, 30);
        hoodieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          //      if(!hoodieFrameOpened) {
                    openHoodieFrame();
                //    hoodieFrameOpened = true;
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
        hoodieFrame.add(createSizeButtonS());
        hoodieFrame.add(createSizeButtonM());
        hoodieFrame.add(createSizeButtonL());
        hoodieFrame.add(createAddToCartButton());

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

    private static JButton createSizeButtonS() {
        JButton sizeS = new JButton("Small");
        sizeS.setBounds(550, 200, 70, 30);
        return sizeS;
    }

    private static JButton createSizeButtonM() {
        JButton sizeM = new JButton("Medium");
        sizeM.setBounds(650, 200, 80, 30);
        return sizeM;
    }

    private static JButton createSizeButtonL() {
        JButton sizeL = new JButton("Large");
        sizeL.setBounds(750, 200, 70, 30);
        return sizeL;
    }

    private static JButton createAddToCartButton() {
        JButton cart = new JButton("Add Cart");
        cart.setBounds(550, 300, 85, 30);
        return cart;
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
        capFrame.add(createSizeButtonS());
        capFrame.add(createSizeButtonM());
        capFrame.add(createSizeButtonL());
        capFrame.add(createAddToCartButton());
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
        toteBagFrame.add(createSizeButtonS());
        toteBagFrame.add(createSizeButtonM());
        toteBagFrame.add(createSizeButtonL());
        toteBagFrame.add(createAddToCartButton());
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
        beanieFrame.add(createSizeButtonS());
        beanieFrame.add(createSizeButtonM());
        beanieFrame.add(createSizeButtonL());
        beanieFrame.add(createAddToCartButton());
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

    protected static void openCartFrame() {
        JFrame cartFrame = new JFrame("Cart Frame");
        cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cartFrame.setSize(1000, 700);
        cartFrame.setLocationRelativeTo(null);
        cartFrame.setVisible(true);
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


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            menuGUI();
            }
        });
    }
}

