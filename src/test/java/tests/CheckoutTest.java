package tests;

import org.testng.annotations.Test;
import pages.CompletePage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test(description = "Check if checkout works")
    public void checkoutShouldWork() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.fillInCheckout("James", "Smith", "134296");
        checkoutOverviewPage.clickFinishButton();
        assertTrue(completePage.isOpened(), "The checkout was not successfull");
    }

    @Test(description = "Check if total price is correct")
    public void totalPriceShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.fillInCheckout("James", "Smith", "134296");
        assertTrue(checkoutOverviewPage.isOpened(), "Checkout page failed to open");
        assertEquals(checkoutOverviewPage.getItemTotalCost(), "Item total: $49.99", "Item total cost error");
        assertEquals(checkoutOverviewPage.getTotalTax(), "Tax: $4.00", "Item tax error");
        assertEquals(checkoutOverviewPage.getTotalCost(), "Total: $53.99", "Total price error");
        checkoutOverviewPage.clickFinishButton();
        assertTrue(completePage.isOpened(), "Checkout error");
    }

    @Test(description = "Check negative checkout - empty fields")
    public void checkOutEmptyFields() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.fillInCheckout("", "", "");
        assertEquals(checkoutPage.getError(), "Error: First Name is required", "Error while checking out");
    }

    @Test(description = "Check negative checkout - empty last name")
    public void checkOutEmptyFieldLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.fillInCheckout("John", "", "");
        assertEquals(checkoutPage.getError(), "Error: Last Name is required", "Error while checking out");

    }

    @Test(description = "Check negative checkout - empty zip")
    public void checkOutEmptyFieldZipCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.fillInCheckout("John", "Smith", "");
        assertEquals(checkoutPage.getError(), "Error: Postal Code is required", "Error while checking out");

    }

    @Test(description = "Check negative checkout - space in fields")
    public void checkOutSpaceInFields() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckoutButton();
        checkoutPage.fillInCheckout(" ", " ", " ");
        assertEquals(checkoutPage.getError(), "Error: First Name is required", "Error while checking out");

    }

}
