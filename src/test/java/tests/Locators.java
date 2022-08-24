package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Locators extends BaseTest{

    @Test
    public void buyProduct() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.linkText("Twitter"));
        driver.findElement(By.partialLinkText("Linked"));
        driver.findElement(By.tagName("button"));



        driver.findElements(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        driver.findElements(By.cssSelector(".btn.btn_primary"));
    }
}
