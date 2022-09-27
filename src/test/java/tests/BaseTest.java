package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CompletePage completePage;
    CheckoutOverviewPage checkoutOverviewPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new ChromeDriver(options);
        } else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        testContext.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        completePage = new CompletePage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);

    }

    @AfterMethod(alwaysRun = true)  // запускать всегда
    public void close() {
        if (driver != null) {
            driver.quit(); }
    }
}
