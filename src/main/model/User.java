package model;

import org.json.JSONArray;
import org.json.JSONObject;

// Represents a user with a name, purchases and cart object
public class User {
    public String userName;               // represent name of the user
    public PurchaseHistory purchases;     // represent purchases made by user
    public Cart cart;                     // represent cart of the user

    /*
     * REQUIRES: addUserName has a non-zero length
     * MODIFIES: this
     * EFFECTS: creates an object of empty userName, purchases, and cart
     */
    public User(String addUserName) {
        this.userName = addUserName;
        purchases = new PurchaseHistory();
        cart = new Cart();
    }

    /*
     * EFFECTS: returns the cart present in this
     */
    public Cart getCart() {
        return this.cart;
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds an ShoppingItem to this
     */
    public void addItemToCart(ShoppingItem newItem) {
        this.cart.addItem(newItem);
    }

    /*
     * EFFECTS: return purchases in this
     */
    public PurchaseHistory getPurchases() {
        return this.purchases;
    }

    /*
     * MODIFIES: this
     * EFFECTS: after a purchase is made purchase history is updated
     */
    public void purchaseItemsInCart() {
        purchases.updatePurchaseHistory(this.cart);
        cart = new Cart();
    }

    /*
     * REQUIRES: ShoppingItems has a non-zero length
     * MODIFIES: this
     * EFFECTS: creates an empty list of ShoppingItem
     */
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("purchases", purchasesToJson());
        jsonObject.put("cart", cartToJson());
        return jsonObject;
    }

    /*
     * REQUIRES: ShoppingItems has a non-zero length
     * MODIFIES: this
     * EFFECTS: creates an empty list of ShoppingItem
     */
    private JSONArray purchasesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (ShoppingItem item : purchases.getPurchaseHistory().values()) {
            jsonArray.put(item.toJson());
        }
        return jsonArray;
    }

    /*
     * REQUIRES: ShoppingItems has a non-zero length
     * MODIFIES: this
     * EFFECTS: creates a item json representation of ShoppingItem
     */
    private JSONArray cartToJson() {
        JSONArray jsonArray = new JSONArray();
        for (ShoppingItem item : cart.getItems().values()) {
            jsonArray.put(item.toJson());
        }
        return jsonArray;
    }
}
