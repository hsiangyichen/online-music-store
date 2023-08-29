package ui.tools;

import model.ShoppingCart;
import persistence.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoadTool extends Tool {

    private static final String JSON_STORE = "./data/shoppingcart.json";
    private ShoppingCart myCart;
    private final JsonReader jsonReader;
    private JLabel label;
    String username;

    public LoadTool(ShoppingCart myCart, String username) {
        super(myCart);
        this.myCart = myCart;
        this.username = username;
        jsonReader = new JsonReader(JSON_STORE);
        createFrame();
        loadCartList();
    }

    @Override
    protected void createLabel() {
        label = new JLabel();
        label.setText("Load Successfully");
        label.setFont(new Font("Serif",Font.PLAIN,22));
        frame.add(label);
        label.setBounds(130,120,700,50);
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a label that represent success when loaded; otherwise throw IOException
     */
    private void loadCartList() {
        try {
            myCart = jsonReader.read();
            createLabel();
            returnButton();
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Return Menu")) {
            frame.dispose();
            new MenuWindow(myCart, username);
        }
    }
}
