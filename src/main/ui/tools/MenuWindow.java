package ui.tools;

import model.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class MenuWindow extends Tool {

    private final ShoppingCart myCart;
    String username;

    public MenuWindow(ShoppingCart myCart, String username) {
        super(myCart);
        this.myCart = myCart;
        this.username = username;
        createFrame();
        createLabel();
        initializeButton();
    }

    @Override
    protected void createLabel() {
        JLabel label = new JLabel();
        label.setText("Hello " + username + "! What can I do for you?");
        label.setFont(new Font("Serif",Font.BOLD,26));
        frame.add(label);
        label.setBounds(180,60,500,100);
    }

    //EFFECTS: set up different function of buttons
    protected void initializeButton() {
        createButton("Add", 280, 150);
        createButton("Remove", 280, 200);
        createButton("Save", 280, 250);
        createButton("Load", 280, 300);
        createButton("Print My Cart",280,350);
        createButton("Exit", 280, 400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            frame.dispose();
            new AddTool(myCart, username);
        } else if (e.getActionCommand().equals("Remove")) {
            frame.dispose();
            new RemoveTool(myCart, username);
        } else if (e.getActionCommand().equals("Save")) {
            frame.dispose();
            new SaveTool(myCart, username);
        } else if (e.getActionCommand().equals("Load")) {
            frame.dispose();
            new LoadTool(myCart, username);
        } else if (e.getActionCommand().equals("Print My Cart")) {
            frame.dispose();
            new PrintCartTool(myCart, username);
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }
}
