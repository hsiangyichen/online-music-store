package ui.tools;

import model.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Tool implements ActionListener {

    static GraphicsConfiguration gc;
    JFrame frame;
    JButton button;

    public Tool(ShoppingCart myCart) {
        frame = new JFrame(gc);
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a JFrame window with all the set up
     */
    protected  void createFrame() {
        frame = new JFrame("Music World");
        frame.setSize(800, 600);
        frame.setLocation(500,500);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(true);
    }

    //https://stackoverflow.com/questions/22638926/how-to-put-hover-effect-on-jbutton
    //This is the method that is called when the the JButton btn is clicked
    public void buttonAction(JButton button) {
        this.button = button;
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.lightGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.getHSBColor(300,200,50));
            }
        });
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a button for user to submit the song
     */
    protected void createButton(String s, int axisX, int axisY) {
        button = new JButton(s);
        button.setBackground(Color.getHSBColor(300,200,50));
        button.setOpaque(true);
        frame.add(button);
        button.addActionListener(this);
        button.setBounds(axisX,axisY,200,30);
        buttonAction(button);
    }

    /*
     * MODIFIES: this
     * EFFECTS: create a JButton in order to return to the menu page
     */
    public void returnButton() {
        JButton newButton = new JButton("Return Menu");
        frame.add(newButton);
        newButton.setBackground(Color.lightGray);
        newButton.addActionListener(this);
        newButton.setBounds(290,400,200,30);
        frame.revalidate();
        frame.repaint();
    }

    protected abstract void createLabel();
}
