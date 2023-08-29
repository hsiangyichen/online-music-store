package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Unit tests for the ShoppingCart class.
 */
public class ShoppingCartTest {
    private ShoppingCart testShoppingCart;

    @BeforeEach
    void runBefore() {
        testShoppingCart = new ShoppingCart();
    }

    @Test
    void testAddElements(){
        testShoppingCart.addSong(new Song("Problem"));
        testShoppingCart.addSong(new Song("Dangerous Woman"));
        testShoppingCart.addSong(new Song("Thank U, Next"));

        assertEquals(new Song("Problem"), testShoppingCart.getMyCartList().get(0));
        assertEquals(new Song("Dangerous Woman"), testShoppingCart.getMyCartList().get(1));
        assertEquals(new Song("Thank U, Next"), testShoppingCart.getMyCartList().get(2));

        testShoppingCart.addSong(new Song("no tears left to cry"));

        assertEquals(new Song("Problem"), testShoppingCart.getMyCartList().get(0));
        assertEquals(new Song("Dangerous Woman"), testShoppingCart.getMyCartList().get(1));
        assertEquals(new Song("Thank U, Next"), testShoppingCart.getMyCartList().get(2));
        assertEquals(new Song("no tears left to cry"), testShoppingCart.getMyCartList().get(3));

        assertEquals(testShoppingCart.getMyCartList().size(), 4);
    }


    @Test
    void testRemoveElements(){
        testShoppingCart.addSong(new Song("Problem"));
        testShoppingCart.addSong(new Song("Dangerous Woman"));
        testShoppingCart.addSong(new Song("Thank U, Next"));
        testShoppingCart.addSong(new Song("no tears left to cry"));

        assertEquals(new Song("Problem"), testShoppingCart.getMyCartList().get(0));
        assertEquals(new Song("Dangerous Woman"), testShoppingCart.getMyCartList().get(1));
        assertEquals(new Song("Thank U, Next"), testShoppingCart.getMyCartList().get(2));
        assertEquals(new Song("no tears left to cry"), testShoppingCart.getMyCartList().get(3));

        testShoppingCart.removeSong(new Song("Thank U, Next"));

        assertEquals(new Song("Problem"), testShoppingCart.getMyCartList().get(0));
        assertEquals(new Song("Dangerous Woman"), testShoppingCart.getMyCartList().get(1));
        assertEquals(new Song("no tears left to cry"), testShoppingCart.getMyCartList().get(2));


        assertEquals(testShoppingCart.getMyCartList().size(), 3);
    }

    @Test
    void testGetTotalPrice() {
        testShoppingCart.addSong(new Song("Problem"));
        testShoppingCart.addSong(new Song("Dangerous Woman"));
        testShoppingCart.addSong(new Song("Thank U, Next"));

        assertEquals(7.5, testShoppingCart.getTotalPrice());
    }

}
