package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By ZIP_CODE = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening Checkout Page")
    public void openCheckoutPage() {
        driver.get(BASE_URL + "checkout-step-one.html");
    }

    @Step("Filling checkout fields in")
    public void fillInCheckout(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}
