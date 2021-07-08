package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

public class TestShoppingItemsInventory {
    public ShoppingItemsInventory testShoppingItemsInventory;
    public PurchaseHistory purchaseHistory;

    @BeforeEach
    void runBefore() {
        ShoppingItem tshirt = new ShoppingItem("Nike",
                "Men's Tshirt",
                "Clothing",
                45.99,
                50,
                4,
                1);
        testShoppingItemsInventory = new ShoppingItemsInventory();
        testShoppingItemsInventory.addItem(tshirt);
        purchaseHistory = new PurchaseHistory();
    }

    @Test
    void testConstructor() {
        assertFalse(testShoppingItemsInventory.getInventory().isEmpty());
    }

    @Test
    void testShoppingItemsInventoryItemNotPresent() {
        ShoppingItem item = testShoppingItemsInventory.getItem(2);
        if (item != null) {
            fail("NullPointerException expected");
        }


    }
}
