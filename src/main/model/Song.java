package model;

/*
 * Represents a song.
 */
public class Song {

    String name; // name of the song
    double unitPrice = 2.5;


    public Song(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Song)) {
            return false;
        }
        Song song = (Song) o;
        return getName().equals(song.getName());
    }

    /*
     * EFFECTS: returns a string representation of name
     * of the songs and its unit price
     */
    @Override
    public String toString() {
        return "Name = " + name + "; Price = " + unitPrice;
    }

}
