package model;

import java.util.HashMap;
import java.util.Map;

// Represents a Cart with a list of shoppingItems
public class Cart {
    private final Map<Integer, ShoppingItem> cart; // creates a map with value ShoppingItem to store in cart

    /*
     * REQUIRES: ShoppingItems has a non-zero length
     * EFFECTS: creates an empty ArrayList of ShoppingItems
     */
    public Cart() {
        cart = new HashMap<>();
    }

    /*
     * REQUIRES: addItems >= 0
     * MODIFIES: this
     * EFFECTS: item is added to the cart object
     */
    public void addItem(ShoppingItem newItem) {
        cart.put(newItem.id, newItem);
    }

    /*
     * EFFECTS: returns the ShoppingItem present in the cart
     */
    public Map<Integer, ShoppingItem> getItems() {
        return this.cart;
    }

}
