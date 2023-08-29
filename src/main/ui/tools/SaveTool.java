package ui.tools;

import model.ShoppingCart;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class SaveTool extends Tool {

    private static final String JSON_STORE = "./data/shoppingcart.json";
    private final ShoppingCart myCart;
    private final JsonWriter jsonWriter;
    private final String username;
    private JLabel label;

    public SaveTool(ShoppingCart myCart, String username) {
        super(myCart);
        this.myCart = myCart;
        this.username = username;
        jsonWriter = new JsonWriter(JSON_STORE);
        createFrame();
        createLabel();
        returnButton();
        saveCartList();
    }

    @Override
    protected void createLabel() {
        label = new JLabel("My Cart List:");
        label.setFont(new Font("Serif",Font.BOLD,24));
        frame.add(label);
        label.setBounds(20,20,200,50);
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a label that represent success when saved; otherwise throw FileNotFoundException
     */
    private void saveCartList() {
        try {
            jsonWriter.open();
            jsonWriter.write(myCart);
            jsonWriter.close();
            DefaultListModel listModel = new DefaultListModel<String>();
            JList list = new JList(listModel);
            for (int i = 0; i < myCart.getMyCartList().size(); i++) {
                listModel.addElement("Saved " + myCart.getMyCartList().get(i).getName() + " to " + JSON_STORE);
            }
            list.setBounds(100,100,200,200);
            frame.add(list);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //This is the method that is called when the the JButton btn is clicked

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Return Menu")) {
            frame.dispose();
            new MenuWindow(myCart, username);
        }
    }
}
