package ui;

import model.ShoppingItem;
import model.ShoppingItemsInventory;
import model.User;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Main driver for the making purchase, adding items to cart, and printing
public class ShoppingApp {
    private final String jsonStore = "./data/shopping_app.json";
    // creates an empty ShoppingItemsInventory
    private final ShoppingItemsInventory inventory = new ShoppingItemsInventory();
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private String brand;
    private String description;
    private String section;
    private double price;
    private int stock;
    private int rating;
    private int id;

    /**
     * default constructor.
     */
    public ShoppingApp() {
        runSystem();
    }

    /**
     * creates a list of default shopping items.
     *
     * @return ShoppingItemsInventory
     */
    public ShoppingItemsInventory makeTestInventory() {
        ShoppingItem tshirt = new ShoppingItem("Nike",
                "Men's T-Shirt",
                "Clothing",
                45.99,
                50,
                4,
                1);            // add an items to ShoppingItemsInventory
        ShoppingItem sanitizer = new ShoppingItem("P&G",
                "Hand Sanitizer",
                "Health",
                5.99,
                500,
                4, 2);  // add an items to ShoppingItemsInventory

        inventory.addItem(tshirt);
        inventory.addItem(sanitizer);
        return inventory;
    }

    /**
     * EFFECTS: user enters fields needed for ShoppingItemsInventory.
     *
     * @param testInventory of type ShoppingItemsInventory
     * @return ShoppingItemsInventory
     */
    public ShoppingItemsInventory addShoppingItems(ShoppingItemsInventory testInventory, Scanner keyboard) {
        String response = "y";
        while (response.charAt(0) != 'n') {
            testInventory.addItem(inputInventoryItem(keyboard));
            System.out.println("Add new item? Enter y or n");
            response = keyboard.nextLine();
            if (response.charAt(0) == 'n') {
                break;
            }
        }
        return testInventory;
    }

    /**
     * REQUIRES: ShoppingItems has a non-zero length
     * MODIFIES: this
     * EFFECTS: takes input from the user
     */
    public ShoppingItem inputInventoryItem(Scanner keyboard) {
        System.out.println("Enter the brand name");
        brand = keyboard.nextLine();
        System.out.println("Enter description");
        description = keyboard.nextLine();
        System.out.println("Enter section (clothing, electronic, etc)");
        section = keyboard.nextLine();
        System.out.println("Enter price");
        price = keyboard.nextDouble();
        System.out.println("Enter stock");
        stock = keyboard.nextInt();
        System.out.println("Enter rating");
        rating = keyboard.nextInt();
        System.out.println("Enter product id");
        id = keyboard.nextInt();
        keyboard.nextLine();
        return new ShoppingItem(brand, description, section, price, stock, rating, id);
    }

    /**
     * EFFECTS: take input from the user for adding item in ShoppingItemsInventory.
     *
     * @return ShoppingItemsInventory
     */
    public ShoppingItemsInventory runFirstTimeSetup(Scanner key, ShoppingItemsInventory inventory) {
        System.out.println("Would you like to enter store items? " + "(default list will be provided)... Enter y or n");
        String response = key.nextLine();
        if (response.charAt(0) == 'y') {
            return addShoppingItems(inventory, key);
        } else {
            return makeTestInventory();
        }
    }

    /**
     * EFFECTS: prints ShoppingItemsInventory on the screen
     */
    public void printStoreInventory(ShoppingItemsInventory inventory) {
        String hyphen = "-";
        System.out.println();
        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Brand", "Description", "Section",
                "Price", "Stock", "Rating", "Id");
        for (int i = 0; i < 140; i++) {
            System.out.print(hyphen);
        }
        System.out.println();
        for (ShoppingItem item : inventory.getInventory()) {
            item.printItem();
        }
    }

    /**
     * EFFECTS: prints menu
     */
    public void printUserOptions() {
        System.out.println();
        System.out.println("Below are a list of options you can choose from:");
        System.out.println("    1. Enter new items into the stores inventory");
        System.out.println("    2. Add item from store inventory to cart");
        System.out.println("    3. Print items in cart");
        System.out.println("    4. Print items in store inventory");
        System.out.println("    5. Purchase items in cart");
        System.out.println("    6. View purchase history");
        System.out.println("    7. Save shopping app state to file");
        System.out.println("    8. Load shopping app state from file");
        System.out.println("    9. Quit program");
    }

    /**
     * EFFECTS: takes input from user and returns inventory if 1 is entered,
     * return item if id is entered, return shopping item if 3 is entered
     * prints inventory if 4 is entered, prints items in cart if 5 is entered,
     * prints purchases if 6 is entered, exit if 7 is entered
     */
    public void mainDriver(User user, ShoppingItemsInventory inventory, Scanner scan) {
        int option = -1;
        while (option != 9) {
            printUserOptions();
            System.out.println("Which option do you choose");
            option = Integer.parseInt(scan.nextLine());
            if (option >= 1 && option <= 4) {
                handle1To4(option, inventory, user, scan);
            } else {
                handle5To9(option, inventory, user, scan);
            }
        }
    }

    /**
     * REQUIRES: ShoppingItems has a non-zero length
     * MODIFIES: this
     * EFFECTS: handles the displayed option
     */
    void handle1To4(int option, ShoppingItemsInventory inventory,
                    User user, Scanner scan) {
        switch (option) {
            case 1:
                inventory = addShoppingItems(inventory, scan);
                break;
            case 2:
                purchaseItem(user, inventory, scan);
                break;
            case 3:
                printCart(user);
                break;
            case 4:
                printStoreInventory(inventory);
                break;
        }
    }

    /**
     * EFFECTS: handles the displayed option
     */
    void handle5To9(int option, ShoppingItemsInventory inventory,
                    User user, Scanner scan) {
        switch (option) {
            case 5:
                user.purchaseItemsInCart();
                break;
            case 6:
                viewPurchaseHistory(user);
                break;
            case 7:
                saveShoppingApp(user, inventory);
                break;
            case 8:
                loadShoppingApp(user, inventory);
                break;
            case 9:
                System.out.println("Exiting... ");
                break;
        }
    }

    /**
     * EFFECTS: handles the purchase of inventory
     */
    private void purchaseItem(User user, ShoppingItemsInventory inventory, Scanner scan) {
        int id;
        System.out.println("Enter the items id");
        id = scan.nextInt();
        scan.nextLine();
        ShoppingItem shoppingItem = inventory.getItem(id);
        if (shoppingItem != null) {
            shoppingItem.decrementStock();
            user.addItemToCart(shoppingItem);
            System.out.println(shoppingItem.description + " of brand " + shoppingItem.brand + " added to cart");
        } else {
            System.out.println("Item with id " + id + " not present in inventory");
        }
    }

    /**
     * EFFECTS: display the purchase history
     */
    private void viewPurchaseHistory(User user) {
        if (user.getPurchases().getPurchaseHistory().isEmpty()) {
            System.out.println("You haven't made any purchases...");
        } else {
            for (ShoppingItem item : user.getPurchases().getPurchaseHistory().values()) {
                item.printItem();
            }
        }
    }

    /**
     * EFFECTS: display the cart
     */
    private void printCart(User user) {
        if (user.getCart().getItems().isEmpty()) {
            System.out.println("The cart is empty...");
        } else {
            for (ShoppingItem item : user.getCart().getItems().values()) {
                item.printItem();
            }
        }
    }

    // EFFECTS: saves the shopping state to file
    private void saveShoppingApp(User user, ShoppingItemsInventory inventory) {
        try {
            jsonWriter.open();
            jsonWriter.write(user, inventory);
            jsonWriter.close();
            System.out.println("Saved shopping state to " + jsonStore);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + jsonStore);
            e.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads shopping app state from file
    private void loadShoppingApp(User user, ShoppingItemsInventory inventory) {
        inventory.getInventory().clear();
        user.getCart().getItems().clear();
        user.getPurchases().getPurchaseHistory().clear();
        try {
            jsonReader.read(user, inventory);
            System.out.println("Loaded shopping app from " + jsonStore);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + jsonStore);
        }
    }

    /**
     * EFFECTS: creates initial user, inventory, keyboard input, username and calls mainDriver for
     * taking user input
     */
    public void runSystem() {
        jsonReader = new JsonReader(jsonStore);
        jsonWriter = new JsonWriter(jsonStore);
        User newUser;
        ShoppingItemsInventory inventory = new ShoppingItemsInventory();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Running first time setup...");
        System.out.print("Enter your name: ");
        String username = keyboard.nextLine();
        newUser = new User(username);
        inventory = runFirstTimeSetup(keyboard, inventory);
        mainDriver(newUser, inventory, keyboard);
    }
}
