package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void loginTestPositive() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened(), "Title of the page is not displayed");
    }

    @Test
    public void wrongPasswordTest() {
        loginPage.open();
        loginPage.login("standard_user", "adds");
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not " +
                "match any user in " + "this service", "Wrong error message is shown");
    }

    @Test
    public void emptyUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required",
                "Wrong error message is shown");
    }

    @Test
    public void loginTestPositiveCaps() {
        loginPage.open();
        loginPage.login("STANDARD_USER", "SECRET_SAUCE");
        assertTrue(productsPage.isOpened(), "Title of the page is not displayed");
    }

    @Test
    public void loginTestUser2() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertTrue(productsPage.isOpened(), "Title of the page is not displayed");
    }

    @Test
    public void loginTestUser3() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
        assertTrue(productsPage.isOpened(), "Title of the page is not displayed");
    }

    @Test
    public void loginTestUser4() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        assertTrue(productsPage.isOpened(), "Title of the page is not displayed");
    }
}
