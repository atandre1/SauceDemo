package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By PAGE_TITLE = By.xpath("//span[text()='Checkout: Overview']");
    private final By FINISH_BUTTON = By.id("finish");
    private final By ITEM_TOTAL = By.cssSelector(".summary_subtotal_label");
    private final By TOTAL_TAX = By.cssSelector(".summary_tax_label");
    private final By TOTAL_COST = By.cssSelector(".summary_total_label");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return driver.findElement(PAGE_TITLE).isDisplayed();
    }

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public String getItemTotalCost(){
        return driver.findElement(ITEM_TOTAL).getText();
    }

    public String getTotalTax() {
        return driver.findElement(TOTAL_TAX).getText();
    }

    public String getTotalCost() {
        return driver.findElement(TOTAL_COST).getText();
    }


}
