package ui.tools;

import model.ShoppingCart;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddTool extends Tool {

    private JLabel label;
    private JTextField textField;
    private final ShoppingCart myCart;
    private JLabel newLabel;
    private final String username;

    public AddTool(ShoppingCart myCart, String username) {
        super(myCart);
        this.myCart = myCart;
        this.username = username;
        createFrame();
        createButton("Confirm", 290, 300);
        createLabel();
        createTextField();
    }

    @Override
    protected void createLabel() {
        label = new JLabel();
        label.setText("Please enter the name of the song that u want to add:");
        label.setFont(new Font("Serif",Font.PLAIN,22));
        frame.add(label);
        label.setBounds(130,120,700,50);
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a text field for user to add a song
     */
    protected void createTextField() {
        textField = new JTextField();
        textField.setForeground(Color.GRAY);
        textField.setFont(new Font("DialogInput", Font.PLAIN,20));
        frame.add(textField);
        textField.setBounds(190,220,400,50);
    }

    //This is the method that is called when the the JButton btn is clicked

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirm")) {
            String textFieldValue = textField.getText();
            newLabel = new JLabel();
            if (!textFieldValue.equals("")) {
                myCart.addSong(new Song(textFieldValue));
                addSuccessfully();
            } else {
                addUnsuccessfully();
            }
        } else if (e.getActionCommand().equals("Return Menu")) {
            frame.dispose();
            new MenuWindow(myCart, username);
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a label that represent success when added
     */
    public void addSuccessfully() {
        newLabel.setText("Add Successfully");
        newLabel.setFont(new Font("Serif",Font.PLAIN,22));
        frame.add(newLabel);
        newLabel.setBounds(310,350,700,50);
        frame.remove(button);
        returnButton();
    }

    public void addUnsuccessfully() {
        newLabel.setText("This is invalid! Please return to menu and add it again.");
        newLabel.setFont(new Font("Serif",Font.PLAIN,22));
        frame.add(newLabel);
        newLabel.setBounds(150,350,700,50);
        returnButton();
    }
}
