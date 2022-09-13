package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage{
    private final By COMPLETE_TITLE = By.xpath("//span[text()='Checkout: Complete!']");

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(COMPLETE_TITLE).isDisplayed();
    }
}