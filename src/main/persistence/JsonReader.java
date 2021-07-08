// Citation: Code in this file has been modeled from given sample
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

package persistence;

import model.ShoppingItem;
import model.ShoppingItemsInventory;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private final String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public void read(User user, ShoppingItemsInventory inventory) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        parseUser(user, jsonObject);
        parseInventory(inventory, jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    /*
     * REQUIRES: ShoppingItems has a non-zero length
     * MODIFIES: this
     * EFFECTS: creates an empty list of ShoppingItem
     */
    private void parseInventory(ShoppingItemsInventory inventory, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("inventory");
        addItemToInventory(inventory, jsonArray);
    }

    /*
     * REQUIRES: ShoppingItems has a non-zero length
     * MODIFIES: this
     * EFFECTS: creates an empty list of ShoppingItem
     */
    private void addItemToInventory(ShoppingItemsInventory inventory, JSONArray jsonArray) {
        for (Object json : jsonArray) {
            JSONObject item = (JSONObject) json;
            addItem(inventory, item);
        }
    }

    // EFFECTS: parses user from JSON object and returns it
    private void parseUser(User user, JSONObject jsonObject) {
        JSONObject userJson = jsonObject.getJSONObject("user");
        addPurchasedItem(user, userJson);
        addToCart(user, userJson);
    }

    // MODIFIES: user
    // EFFECTS: parses purchases from JSON object and adds them to history
    private void addPurchasedItem(User user, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("purchases");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addItem(user, nextThingy);
        }
        user.purchaseItemsInCart();
    }

    // MODIFIES: user
    // EFFECTS: parses Cart from JSON object and adds them to Inventory
    private void addToCart(User user, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("cart");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addItem(user, nextThingy);
        }
    }

    // MODIFIES: user
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addItem(User user, JSONObject jsonObject) {
        String brand = jsonObject.getString("brand");
        String description = jsonObject.getString("description");
        String section = jsonObject.getString("section");
        double price = jsonObject.getDouble("price");
        int stock = jsonObject.getInt("stock");
        int rating = jsonObject.getInt("rating");
        int id = jsonObject.getInt("id");
        ShoppingItem item = new ShoppingItem(brand, description, section,
                price, stock, rating, id);
        user.addItemToCart(item);
    }

    /*
     * EFFECTS: adds a ShoppingItem
     */
    private void addItem(ShoppingItemsInventory inventory, JSONObject jsonObject) {
        String brand = jsonObject.getString("brand");
        String description = jsonObject.getString("description");
        String section = jsonObject.getString("section");
        double price = jsonObject.getDouble("price");
        int stock = jsonObject.getInt("stock");
        int rating = jsonObject.getInt("rating");
        int id = jsonObject.getInt("id");
        ShoppingItem item = new ShoppingItem(brand, description, section,
                price, stock, rating, id);
        inventory.addItem(item);
    }
}
