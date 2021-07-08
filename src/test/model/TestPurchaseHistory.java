package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPurchaseHistory {
    public Cart testCart;
    public PurchaseHistory purchaseHistory;
    User user;

    @BeforeEach
    void runBefore() {
        ShoppingItem tshirt = new ShoppingItem("Nike",
                "Men's Tshirt",
                "Clothing",
                45.99,
                50,
                4,
                1);
        testCart = new Cart();
        testCart.addItem(tshirt);
        purchaseHistory = new PurchaseHistory();
    }

    @Test
    void testConstructor() {
        assertTrue(purchaseHistory.getPurchaseHistory().isEmpty());
    }

    @Test
    void testPurchaseHistory() {
        purchaseHistory.updatePurchaseHistory(testCart);
        assertEquals(1, purchaseHistory.getPurchaseHistory().size());
        assertEquals("Men's Tshirt", purchaseHistory.getPurchaseHistory().get(1).description);

    }
}
