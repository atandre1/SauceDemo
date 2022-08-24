package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkPrice() {
        productsPage.open();
        productsPage.addToCart("Sauce Labs Backpack");

    }
}
