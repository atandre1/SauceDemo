package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {

    @Test
    public void productPriceInTheCartShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), "$29.99",
                "Product price is incorrect");


        // залить в мастер
        // вынести в константы бейстест логин и пароль стандартные
    }
}
