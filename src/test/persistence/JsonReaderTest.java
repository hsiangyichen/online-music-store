package persistence;

import model.Song;
import model.ShoppingCart;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ShoppingCart sc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            ShoppingCart sc = reader.read();
            assertEquals(0, sc.getMyCartList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            ShoppingCart sc = reader.read();
            List<Song> songs = sc.getMyCartList();
            assertEquals(2, songs.size());
            checkSong("Problem", songs.get(0));
            checkSong("Flashlight", songs.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
