import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pom.BasePage;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public  String url = null;
    public  BasePage basePage = null;
    @DataProvider(name="IncorrectLoginData")
    public Object[][] getDataFromDataProviders() {

        return new Object[][] {
                {"invalid@mail.com", "invalidPass"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        basePage = new BasePage(driver);

        url = BaseURL;
        navigateToPage();
    }
    @AfterMethod
    public void closeBrowser() {
        basePage.quitDriver();
    }
    public  void navigateToPage() {
        basePage.navigate(url);
    }

}