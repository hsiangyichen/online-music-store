package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Unit tests for the Song class.
 */
class SongTest {
    private Song testSong;
    private String string1 = "hello";

    @BeforeEach
    void runBefore() {
        testSong = new Song("dangerous woman");
    }

    @Test
    void testConstructor() {
        assertEquals("dangerous woman", testSong.getName());
    }

    @Test
    void testGetUnitPrice() {
        assertEquals(testSong.getUnitPrice(), 2.5);
    }

    @Test
    void testToString() {
        assertTrue( testSong.toString().contains("Name = dangerous woman; Price = 2.5"));
    }

    @Test
    void testEquals() {
        String string2 = "hello";
        testSong = new Song("dangerous woman");
        assertTrue(string1.equals(string2));
        assertTrue(testSong.equals(new Song("dangerous woman")));
        assertFalse(testSong.equals(new Song("Problem")));
        assertFalse(testSong.equals(string1));
    }
}