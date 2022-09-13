package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {



    @Test(description = "Check if correct login works")
    public void loginTestPositive() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isOpened(), "Title of the page is not displayed");
    }

    @DataProvider
    public Object[][] loginData() {    //Делаем много негативных тестов в одном. Параметризованные тесты
        return new Object[][]{
                {"standard_user", "adds", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
        };
    }

    @Test(dataProvider = "loginData")
    public void negativeLogin(String userName, String password, String error) {
        loginPage.open();
        loginPage.login(userName, password);
        assertEquals(loginPage.getError(), error, "Wrong error message is shown");
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
