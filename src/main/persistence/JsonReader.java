package persistence;

import model.Song;
import model.ShoppingCart;
import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


import org.json.*;

// Represents a reader that reads the playlist from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads playlist from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ShoppingCart read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseReceipt(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses shopping cart from JSON object and returns it
    private ShoppingCart parseReceipt(JSONObject jsonObject) {
        ShoppingCart sc = new ShoppingCart();
        addSongs(sc, jsonObject);
        return sc;
    }

    // MODIFIES: sc
    // EFFECTS: parses songs from JSON object and adds them to cart list
    private void addSongs(ShoppingCart sc, JSONObject jsonObject) {

        JSONArray line = jsonObject.names();

        if (line == null) {
            return;
        }
        for (int i = 0; i < line.length(); ++i) {
            String songNames = line.getString(i);
            sc.addSong(new Song(songNames));
        }

    }
}
