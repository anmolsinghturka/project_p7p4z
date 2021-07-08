package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {
    public User testUser;
    public PurchaseHistory purchaseHistory;
    public ShoppingItemsInventory inventory;

    @BeforeEach
    void runBefore() {
        inventory = new ShoppingItemsInventory();
        ShoppingItem tshirt = new ShoppingItem("Nike",
                "Men's Tshirt",
                "Clothing",
                45.99,
                50,
                4,
                1);
        inventory.addItem(tshirt);
        testUser = new User("John Doe");
        purchaseHistory = new PurchaseHistory();
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", testUser.userName);
    }

    @Test
    void testUserCart() {
        testUser.addItemToCart(inventory.getItem(1));
        assertEquals(testUser.getCart().getItems().get(1).description, "Men's Tshirt");
        assertEquals(1, testUser.getCart().getItems().size());
    }

    @Test
    void testUserPurchases() {
        testUser.addItemToCart(inventory.getItem(1));
        testUser.purchaseItemsInCart();
        assertEquals(testUser.getPurchases().getPurchaseHistory().get(1).description, "Men's Tshirt");
        assertEquals(1, testUser.getPurchases().getPurchaseHistory().size());
    }


}
