package edu.fgcu.bookstore.models;

import edu.fgcu.bookstore.enums.GENRE;

public class Hardcover extends PhysicalBook {
    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private String coverType; // e.g., Softcover, Hardcover
    private float weight; // in grams

    // Constructors
    // ----------------------
    public Hardcover() {}

    public Hardcover(String title, String isbn, Author author, Publisher publisher, int pageCount, float price, GENRE genre, String coverType, float weight) {
        super(title, isbn, author, publisher, pageCount, price, genre, coverType, weight);
        this.coverType = coverType;
        this.weight = weight;
    }

    // Getters and Setters
    // --------
    public String getCoverType() { return coverType; }
    public void setCoverType(String coverType) { this.coverType = coverType; }

    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }
}
