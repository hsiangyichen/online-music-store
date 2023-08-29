package ui.tools;

import model.ShoppingCart;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintCartTool extends Tool {

    private final ShoppingCart myCart;
    private JLabel label;
    private final String username;

    public PrintCartTool(ShoppingCart myCart, String username) {
        super(myCart);
        this.myCart = myCart;
        this.username = username;
        createFrame();
        createLabel();
        myCartList();
        returnButton();

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
     * EFFECTS: create a list of all the songs that the user add
     */
    private void myCartList() {
        DefaultListModel listModel = new DefaultListModel<String>();
        JList list = new JList(listModel);
        for (int i = 0; i < myCart.getMyCartList().size(); i++) {
            Song temp = myCart.getMyCartList().get(i);
            listModel.addElement("Song " + (i + 1) + ": " + temp.toString());
        }
        list.setBounds(100,100,200,200);
        frame.add(list);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Return Menu")) {
            frame.dispose();
            new MenuWindow(myCart, username);
        }
    }
}
