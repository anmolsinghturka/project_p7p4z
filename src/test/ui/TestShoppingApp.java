package ui;

import model.ShoppingItem;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShoppingApp {
    ShoppingApp app;

    @Test
    void testShoppingApp() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = new ByteArrayInputStream("Test\nn\n4\n9".getBytes());
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        System.setIn(in);
        System.setOut(new PrintStream(out));
        app = new ShoppingApp();
        String expected = "Running first time setup...\n" +
                "Enter your name: Would you like to enter store items? (default list will be provided)... Enter y or n\n" +
                "\n" +
                "Below are a list of options you can choose from:\n" +
                "    1. Enter new items into the stores inventory\n" +
                "    2. Add item from store inventory to cart\n" +
                "    3. Print items in cart\n" +
                "    4. Print items in store inventory\n" +
                "    5. Purchase items in cart\n" +
                "    6. View purchase history\n" +
                "    7. Save shopping app state to file\n" +
                "    8. Load shopping app state from file\n" +
                "    9. Quit program\n" +
                "Which option do you choose\n\n";
        expected += String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Brand", "Description", "Section",
                "Price", "Stock", "Rating", "Id");
        expected += "--------------------------------------------------------------------------------------------------------------------------------------------\n";
        expected += String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Nike", "Men's T-Shirt",
                "Clothing", "45.99", "50", "4", "1");
        expected += String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "P&G", "Hand Sanitizer",
                "Health", "5.99", "500", "4", "2");
        expected += "\nBelow are a list of options you can choose from:\n" +
                "    1. Enter new items into the stores inventory\n" +
                "    2. Add item from store inventory to cart\n" +
                "    3. Print items in cart\n" +
                "    4. Print items in store inventory\n" +
                "    5. Purchase items in cart\n" +
                "    6. View purchase history\n" +
                "    7. Save shopping app state to file\n" +
                "    8. Load shopping app state from file\n" +
                "    9. Quit program\n" +
                "Which option do you choose\n" +
                "Exiting... \n";

        assertEquals(expected, out.toString().replaceAll("\r", ""));

        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testShoppingAppComplete() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = new ByteArrayInputStream(("Test\nn\n1\nTest Brand" +
                "\nTest Product\nTest Section\n6.99\n200\n3\n5\nn\n2\n1\n3\n4\n5\n6\n7\n8\n9").getBytes());
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        System.setIn(in);
        System.setOut(new PrintStream(out));
        Main.main(null);
        ShoppingItem sanitizer = new ShoppingItem("P&G",
                "Hand Sanitizer",
                "Health",
                5.99,
                1,
                4,
                2);

        assertEquals(sanitizer.description, "Hand Sanitizer");
        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}
