package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void addItemToCart() {loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.clickCart();

        assertEquals(cartPage.getQuantityOfItemsInCart(), "1", "The number of items is wrong");
    }

    @Test
    public void removeFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.clickCart();
        assertEquals(cartPage.getQuantityOfItemsInCart(), "2", "The number of items is wrong");
        cartPage.removeFromCard();
        assertEquals(cartPage.getQuantityOfItemsInCart(), "1", "The number of items is wrong");
    }
}
