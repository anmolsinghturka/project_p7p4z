package model;

import java.util.HashMap;
import java.util.Map;

// Represents a list of history of purchases made by the user
public class PurchaseHistory {
    Map<Integer, ShoppingItem> purchaseHistory; // creates a map of value ShoppingItem to keep track of purchases

    /*
     * REQUIRES: ShoppingItems has a non-zero length
     * MODIFIES: this
     * EFFECTS: creates an empty list of ShoppingItem
     */
    public PurchaseHistory() {
        this.purchaseHistory = new HashMap<>();
    }

    /*
     * REQUIRES: newPurchases >= 0
     * MODIFIES: this
     * EFFECTS: purchases are added to this
     */
    public void updatePurchaseHistory(Cart newPurchases) {
        for (Map.Entry<Integer, ShoppingItem> newItem : newPurchases.getItems().entrySet()) {
            purchaseHistory.put(newItem.getKey(), newItem.getValue());
        }
    }

    /*
     * EFFECTS: returns the ShoppingItem present in this
     */
    public Map<Integer, ShoppingItem> getPurchaseHistory() {
        return this.purchaseHistory;
    }
}
