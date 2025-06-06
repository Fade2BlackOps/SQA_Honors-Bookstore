package edu.fgcu.bookstore.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    // Private attributes for encapsulation
    // -------------------------------------------------------------------------
    private Customer customer; // Customer associated with the cart
    private Map<Book, Integer> items; // Maps book to quantity in cart
    private float totalPrice = 0.00f; // Total price of items in the cart

    // Constructors
    // ----------------------
    public Cart() {
        this.items = new HashMap<>();
    }

    public Cart(Customer customer) {
        this.customer = customer;
        this.items = new HashMap<>();
    }

    public Cart(Person customer2) {
        //TODO Auto-generated constructor stub
    }

    // Getters and Setters
    // --------
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Map<Book, Integer> getItems() { return items; }

    public float getTotalPrice() { 
        return calculateTotalPrice(); // Calculate total price when requested
    }
    public void setTotalPrice(float totalPrice) { 
        this.totalPrice = totalPrice; 
    }
    
    // Methods
    // --------------
    
    /**
     * Adds a book to the cart.
     * @param book The book to add.
     * @param quantity The quantity of the book to add.
     */
    public void addBookToCart(Book book, int quantity) {
        if (quantity > 0) {
            items.put(book, items.getOrDefault(book, 0) + quantity);
            System.out.println("Added " + quantity + " copies of book with ISBN " + book.getIsbn() + " to cart.");
        } else {
            System.out.println("Quantity must be greater than zero.");
        }
        totalPrice = calculateTotalPrice(); // Update total price after adding
    }

    /**
     * Removes a book from the cart.
     * @param book The book to remove.
     */
    public void removeBookFromCart(Book book) {
        if (items.containsKey(book)) {
            items.remove(book);
            System.out.println("Removed book with ISBN " + book.getIsbn() + " from cart.");
        } else {
            System.out.println("Book with ISBN " + book.getIsbn() + " not found in cart.");
        }
        totalPrice = calculateTotalPrice(); // Update total price after removing
    }

    /**
     * Calculates the total price of items in the cart.
     * @return The total price.
     */
    public float calculateTotalPrice() {
        totalPrice = 0.00f;
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += book.getPrice() * quantity; // Assuming Book has a getPrice() method
        }
        return totalPrice;
    }

    /**
     * Displays the contents of the cart.
     */
    public void displayCartContents() {
        System.out.println("Cart Contents:");
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Quantity: " + quantity);
        }
        System.out.println("Total Price: $" + totalPrice);
    }

    /**
     * Clears the cart.
     */
    public void clearCart() {
        items.clear();
        totalPrice = 0.00f;
        System.out.println("Cart has been cleared.");
    }

    /**
     * Checks if the cart is empty.
     * @return true if the cart is empty, false otherwise.
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Returns a string representation of the cart.
     * @return A string representing the cart.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart for ").append(customer.getName()).append(":\n");
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            sb.append("ISBN: ").append(book.getIsbn())
              .append(", Title: ").append(book.getTitle())
              .append(", Quantity: ").append(quantity).append("\n");
        }
        sb.append("Total Price: $").append(totalPrice).append("\n");
        return sb.toString();
    }
    
}