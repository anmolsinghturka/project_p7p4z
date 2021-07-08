package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShoppingItem {
    public ShoppingItem testShoppingItem;

    @BeforeEach
    void runBefore() {
        testShoppingItem = new ShoppingItem("Nike",
                "Men's Tshirt",
                "Clothing",
                45.99,
                50,
                4,
                1);
    }

    @Test
    void testConstructor() {
        assertEquals("Nike", testShoppingItem.brand);
        assertEquals("Men's Tshirt", testShoppingItem.description);
        assertEquals("Clothing", testShoppingItem.section);
        assertEquals(45.99, testShoppingItem.price);
        assertEquals(50, testShoppingItem.stock);
        assertEquals(4, testShoppingItem.rating);
        assertEquals(1, testShoppingItem.id);
    }

    @Test
    void testOutOfStock() {
        ShoppingItem sanitizer = new ShoppingItem("P&G",
                "Hand Sanitizer",
                "Health",
                5.99,
                1,
                4,
                2);
        sanitizer.decrementStock();
        sanitizer.decrementStock();
        assertEquals(0, sanitizer.stock);

        sanitizer.incrementStock();
        assertEquals(1, sanitizer.stock);

        assertEquals(2, sanitizer.getId());
    }
}
