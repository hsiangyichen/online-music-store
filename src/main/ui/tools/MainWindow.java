package ui.tools;

import model.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends Tool implements ActionListener {
    private final ShoppingCart myCart;
    private JTextField textField;
    private JLabel arrowLabel;
    private int arrowY = 220;
    private Timer timer;

    public MainWindow(ShoppingCart myCart) {
        super(myCart);
        this.myCart = myCart;
        initialize();
        startAnimation();
    }

    private void initialize() {
        createFrame();

        ImageIcon backgroundImage = new ImageIcon("background.jpg"); // Set background image
        Image img = backgroundImage.getImage();
        Image scaledImage = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        frame.setContentPane(new JLabel(scaledBackgroundImage));

        createLabel();
        createButton("Submit", 330, 330, 140, 35);
        createTextField();
        createArrow();
        frame.setVisible(true);
    }

    @Override
    protected void createLabel() {
        JLabel label1 = new JLabel("Welcome to the Music World");
        label1.setFont(new Font("Serif", Font.BOLD, 24));
        frame.add(label1);
        label1.setBounds(200, 170, 400, 50);

        JLabel label2 = new JLabel("Here");
        label2.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(label2);
        label2.setBounds(200, 220, 70, 50); // Adjust width of label2

        JLabel label3 = new JLabel("Enter your name:");
        label3.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(label3);
        label3.setBounds(290, 220, 400, 50); // New label for "Enter your name:"
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a text field for user to enter their name
     */
    protected void createTextField() {
        textField = new JTextField();
        textField.setForeground(Color.GRAY);
        textField.setFont(new Font("DialogInput", Font.PLAIN,20));
        frame.add(textField);
        textField.setBounds(200,280,400,30);
    }

    protected void createArrow() {
        arrowLabel = new JLabel("⬇");
        arrowLabel.setFont(new Font("Serif", Font.BOLD, 24));
        frame.add(arrowLabel);
        arrowLabel.setBounds(260, arrowY, 50, 50); // Adjust X position
    }

    protected void startAnimation() {
        timer = new Timer(400, this);
        timer.start();
    }

    protected void createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.PLAIN, 16));
        button.setBounds(x, y, width, height); // Set the bounds with specified width and height
        button.addActionListener(this); // Add ActionListener
        frame.add(button);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            // Toggle direction of arrow movement
            if (arrowY == 220) {
                arrowY = 215;
            } else {
                arrowY = 220;
            }
            arrowLabel.setBounds(262, arrowY, 50, 50);
        } else if (e.getActionCommand().equals("Submit")) {
            String username = textField.getText();
            new Sound();
            frame.dispose();
            new MenuWindow(myCart, username);
        }
    }
}
