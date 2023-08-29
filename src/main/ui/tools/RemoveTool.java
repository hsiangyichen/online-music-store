package ui.tools;

import model.ShoppingCart;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RemoveTool extends Tool {

    private JLabel label;
    private JTextField textField;
    private final ShoppingCart myCart;
    private String username;

    public RemoveTool(ShoppingCart myCart, String username) {
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
        label.setText("Please enter the name of the song that u want to remove:");
        label.setFont(new Font("Serif",Font.PLAIN,22));
        frame.add(label);
        label.setBounds(130,120,700,50);
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a text field for user to remove a song
     */
    protected void createTextField() {
        textField = new JTextField();
        textField.setForeground(Color.GRAY);
        textField.setFont(new Font("DialogInput", Font.PLAIN,20));
        frame.add(textField);
        textField.setBounds(190,220,400,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirm")) {
            String textFieldValue = textField.getText();
            if (myCart.getMyCartList().size() == 0) {
                nothingThere();
            } else {
                ifSongExistOrNOt(textFieldValue);
            }
        } else if (e.getActionCommand().equals("Return Menu")) {
            frame.dispose();
            new MenuWindow(myCart, username);
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: check if the song is in the shopping cart
     */
    public void ifSongExistOrNOt(String textFieldValue) {
        boolean songExist = true;
        for (int i = 0; i < myCart.getMyCartList().size(); i++) {
            Song temp = myCart.getMyCartList().get(i);
            if (textFieldValue.equals(myCart.getMyCartList().get(i).getName())) {
                myCart.removeSong(temp);
                removeSuccessfully();
                songExist = true;
                break;
            } else {
                songExist = false;
            }
        }
        if (!songExist) {
            notExist();
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a label that represent there is no such song in your shopping cart
     */
    public void notExist() {
        label = new JLabel();
        label.setText("SORRY! There is no such song in your shopping cart.");
        label.setFont(new Font("Serif",Font.PLAIN,22));

        frame.add(label);
        label.setBounds(170,350,700,50);
        frame.remove(button);
        returnButton();
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a label that represent there is nothing in the shopping cart
     */
    public void nothingThere() {
        label = new JLabel();
        label.setText("There is nothing in your shopping cart.");
        label.setFont(new Font("Serif",Font.PLAIN,22));

        frame.add(label);
        label.setBounds(220,350,700,50);
        frame.remove(button);
        returnButton();
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a label that represent success when removed
     */
    public void removeSuccessfully() {
        label = new JLabel();
        label.setText("Remove Successfully");
        label.setFont(new Font("Serif",Font.PLAIN,22));
        frame.add(label);
        label.setBounds(295,350,700,50);
        frame.remove(button);
        returnButton();
    }
}
