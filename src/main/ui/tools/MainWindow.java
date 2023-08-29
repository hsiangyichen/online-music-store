package ui.tools;

import model.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends Tool {

    private final ShoppingCart myCart;
    private JTextField textField;

    public MainWindow(ShoppingCart myCart) {
        super(myCart);
        this.myCart = myCart;
        initialize();
    }

    // initialize all the functions in order to perform a main window
    private void initialize() {
        createFrame();
        createLabel();
        createButton("Submit",300,280);
        createTextField();
    }

    @Override
    protected void createLabel() {
        JLabel label = new JLabel();
        label.setText("Enter your name:");
        label.setFont(new Font("Serif",Font.BOLD,24));
        frame.add(label);
        label.setBounds(200,170,300,50);
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
        textField.setBounds(200,230,400,30);
    }

    //This is the method that is called when the the JButton btn is clicked

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            String username = textField.getText();
            new Sound();
            frame.dispose();
            new MenuWindow(myCart, username);
        }
    }
}
