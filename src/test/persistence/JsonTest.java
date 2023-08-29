package persistence;

import model.Song;
import model.ShoppingCart;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkSong(String name, Song song) {
        assertEquals(name, song.getName());
    }
}
