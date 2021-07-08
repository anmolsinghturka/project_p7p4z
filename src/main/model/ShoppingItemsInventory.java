package model;

import org.json.JSONArray;

import java.util.ArrayList;

// Represents an inventory of the ShoppingItems
public class ShoppingItemsInventory {
    private final ArrayList<ShoppingItem> inventory;   // creates an array of ShoppingItem to keep track of inventory

    /*
     * REQUIRES: ShoppingItems has a non-zero length
     * EFFECTS: creates an empty list of ShoppingItem
     */
    public ShoppingItemsInventory() {
        inventory = new ArrayList<ShoppingItem>();
    }

    /*
     * EFFECTS: return items in the inventory if there are items left otherwise null
     */
    public ShoppingItem getItem(int id) {
        for (ShoppingItem item : this.inventory) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds an item to this if passed in as ShoppingItem object
     */
    public void addItem(ShoppingItem item) {
        inventory.add(item);
    }

    /*
     * EFFECTS: returns the ShoppingItem present in this
     */
    public ArrayList<ShoppingItem> getInventory() {
        return this.inventory;
    }

    public JSONArray toJson() {
        JSONArray jsonArray = new JSONArray();
        for (ShoppingItem item : inventory) {
            jsonArray.put(item.toJson());
        }
        return jsonArray;
    }
}
