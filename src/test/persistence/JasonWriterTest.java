package persistence;


import org.junit.jupiter.api.Test;
import model.Song;
import model.ShoppingCart;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            ShoppingCart myCart = new ShoppingCart();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            ShoppingCart myCart = new ShoppingCart();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyShoppingCart.json");
            writer.open();
            writer.write(myCart);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyShoppingCart.json");
            myCart = reader.read();
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            ShoppingCart myCart = new ShoppingCart();
            myCart.addSong(new Song("Problem"));
            myCart.addSong(new Song("Flashlight"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralShoppingCart.json");
            writer.open();
            writer.write(myCart);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralShoppingCart.json");
            myCart = reader.read();
            List<Song> songs = myCart.getMyCartList();
            assertEquals(2, songs.size());
            checkSong("Problem", songs.get(0));
            checkSong("Flashlight", songs.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}