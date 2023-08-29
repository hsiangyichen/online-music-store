package model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/*
 * Represents a shopping cart.
 */
public class ShoppingCart {

    private List<Song> myCartList; // create a list to add all the songs
    private double totalPrice;

    public ShoppingCart() {
        myCartList = new ArrayList<>();
    }

    public List<Song> getMyCartList() {
        return myCartList;
    }

    /*
     * MODIFIES: this
     * EFFECTS: new song is added to the list and updated
     * 			list is returned
     */
    public void addSong(Song song) {
        myCartList.add(song);
    }

    /*
     * MODIFIES: this
     * EFFECTS: song is deleted from the list and updated
     * 			list is returned
     */
    public void removeSong(Song song) {
        myCartList.remove(song);
    }

    /*
     * MODIFIES: this
     * EFFECTS: total price will be changed by the number of the songs
     */
    public double getTotalPrice() {
        totalPrice = myCartList.get(0).getUnitPrice() * myCartList.size();
        return totalPrice;
    }

    // EFFECTS: returns the name of the song and the price on cart list as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        for (int i = 0; i < myCartList.size(); i++) {
            Song song1 = myCartList.get(i);
            String s1 = song1.getName();
            json.put(s1, song1.getUnitPrice());
        }
        return json;
    }
}

