package ui;

import model.ShoppingCart;
import ui.tools.MainWindow;

import java.io.IOException;

public class Main {

    private static ShoppingCart myCart;

    public static void main(String[] args) throws IOException {
        myCart = new ShoppingCart();
        new MainWindow(myCart);
    }
}
