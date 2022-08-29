package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTest extends BaseTest {

    @Test
    public void productPriceInTheCartShouldBeCorrect() {
        loginPage.open();
        loginPage.login("perfomance_glitch_user", "secret_sauce");
        assertTrue(productsPage.isOpened());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        assertTrue(cartPage.isOpened());
        assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), "$29.99",
                "Product price is incorrect");



    }
}
