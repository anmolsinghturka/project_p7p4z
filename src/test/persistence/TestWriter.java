package persistence;

import model.ShoppingItem;
import model.ShoppingItemsInventory;
import model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestWriter {

    @Test
    void testWriterInvalidFile() {
        try {
            User user = new User("test");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmpty() {
        try {
            User user = new User("test");
            ShoppingItemsInventory inventory = new ShoppingItemsInventory();
            JsonWriter writer = new JsonWriter("./data/testWriterEmpty.json");
            writer.open();
            writer.write(user, inventory);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmpty.json");
            reader.read(user, inventory);
            assertEquals(0, user.getCart().getItems().size());
            assertEquals(0, user.getPurchases().getPurchaseHistory().size());
            assertEquals(0, inventory.getInventory().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneral() {
        try {
            User user = new User("test");
            ShoppingItemsInventory inventory = new ShoppingItemsInventory();
            ShoppingItem tShirt = new ShoppingItem("Nike",
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
            ShoppingItem laptop = new ShoppingItem("Apple",
                    "15 inch laptop",
                    "Electronics",
                    1499.99,
                    5,
                    4,
                    3);              // add an items to ShoppingItemsInventory

            inventory.addItem(tShirt);
            inventory.addItem(sanitizer);
            inventory.addItem(laptop);

            user.addItemToCart(inventory.getItem(1));
            user.addItemToCart(inventory.getItem(2));

            user.purchaseItemsInCart();

            user.addItemToCart(inventory.getItem(3));

            JsonWriter writer = new JsonWriter("./data/testWriterGeneral.json");
            writer.open();
            writer.write(user, inventory);
            writer.close();

            user = new User("test");
            inventory = new ShoppingItemsInventory();
            JsonReader reader = new JsonReader("./data/testWriterGeneral.json");
            reader.read(user, inventory);
            assertEquals(2, user.getPurchases().getPurchaseHistory().size());
            assertEquals(1, user.getCart().getItems().size());
            assertEquals(3, inventory.getInventory().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
