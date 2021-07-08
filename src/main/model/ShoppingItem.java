package model;

import org.json.JSONObject;

// Represents a ShoppingItem having a brand, description, section, price(in dollars), stock, rating, id
public class ShoppingItem {
    public String brand;            // tracks brand of the shopping item
    public String description;      // tracks description of the shopping item
    public String section;          // tracks section of the shopping item
    public double price;            // tracks price of the shopping item
    public int stock;               // tracks stock of the shopping item
    public int rating;              // tracks rating of the shopping item
    public int id;                  // tracks id of the shopping item

    /*
     * REQUIRES: addPrice, addStock, addRating, id has a non-zero length
     * MODIFIES: this
     * EFFECTS: brand on ShoppingItem is set to addBrand; description on ShoppingItem is set to addDescription;
     *          section on ShoppingItem is set to addSection; price on ShoppingItem is set to addPrice;
     *          stock on ShoppingItem is set to addStock; rating on ShoppingItem is set to addRating;
     *          id on ShoppingItem is set to addID;
     */
    public ShoppingItem(String brand, String description, String section, double price, int stock, int rating, int id) {
        this.brand = brand;
        this.description = description;
        this.section = section;
        this.price = price;
        this.stock = stock;
        this.rating = rating;
        this.id = id;
    }

    /*
     * EFFECTS: return the list of field in this in proper format
     */
    public void printItem() {
        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", this.brand, this.description, this.section,
                this.price, this.stock, this.rating, this.id);
    }

    /*
     * EFFECTS: return id of this
     */
    public int getId() {
        return this.id;
    }

    /*
     * REQUIRES: stock >= 0
     * MODIFIES: this
     * EFFECTS: stock is decremented by one
     */
    public void decrementStock() {
        if (stock > 0) {
            this.stock--;
        }
    }

    /*
     * REQUIRES: stock >= 0
     * MODIFIES: this
     * EFFECTS: stock is incremented by one
     */
    public void incrementStock() {
        this.stock++;
    }

    /*
     * REQUIRES: ShoppingItems has a non-zero length
     * MODIFIES: this
     * EFFECTS: creates a item json representation of ShoppingItem
     */
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brand", brand);
        jsonObject.put("description", description);
        jsonObject.put("section", section);
        jsonObject.put("price", price);
        jsonObject.put("stock", stock);
        jsonObject.put("rating", rating);
        jsonObject.put("id", id);
        return jsonObject;
    }
}
