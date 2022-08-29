package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By CHECKOUT_BUTTON = By.id("checkout");
    private final By CART_ITEM = By.cssSelector(".inventory_item_name");
    private final By REMOVE_BUTTON = By.xpath("//*[text()='Remove']");
    private String numberOfItems;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice(String product) {
        String locator = String.format("//div[text()='%s']//ancestor::" +
                "div[@class='cart_item']//div[@class='inventory_item_price']", product);
        return driver.findElement(By.xpath(locator)).getText();

    }

    public boolean isOpened() {
        return waitForVisibility(CHECKOUT_BUTTON);
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void removeFromCard() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public String getQuantityOfItemsInCart() {
        int arraySize = driver.findElements(CART_ITEM).size();
        return numberOfItems = Integer.toString(arraySize);
    }


}
