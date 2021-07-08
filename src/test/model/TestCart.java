package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestCart {
    public Cart testCart;

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
    }

    @Test
    void testConstructor() {
        assertFalse(testCart.getItems().isEmpty());
    }

    @Test
    void testCartItem() {
        assertEquals(1, testCart.getItems().size());
        assertEquals(testCart.getItems().get(1).description, "Men's Tshirt");
    }
}
