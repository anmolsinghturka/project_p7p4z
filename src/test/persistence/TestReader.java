package persistence;

import model.ShoppingItemsInventory;
import model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestReader {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        ShoppingItemsInventory inventory = new ShoppingItemsInventory();
        User user = new User("test");
        try {
            reader.read(user, inventory);
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderGeneralPurchaseHistory() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPurchaseHistory.json");
        ShoppingItemsInventory inventory = new ShoppingItemsInventory();
        User user = new User("test");
        try {
            reader.read(user, inventory);
            assertEquals(2, user.getPurchases().getPurchaseHistory().size());
            assertEquals(0, user.getCart().getItems().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCart() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCart.json");
        ShoppingItemsInventory inventory = new ShoppingItemsInventory();
        User user = new User("test");
        try {
            reader.read(user, inventory);
            assertEquals(0, user.getPurchases().getPurchaseHistory().size());
            assertEquals(2, user.getCart().getItems().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
