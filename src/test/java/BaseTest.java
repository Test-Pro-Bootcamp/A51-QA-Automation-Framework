import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.time.Instant;

import java.util.function.Function;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;


    //Setup WebDriverManager for ChromeDriver
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    //Launch Chrome browser and navigate to BaseUrl
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) throws InterruptedException {
        //Added ChromeOptions argument to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(BaseUrl);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait = WebDriverWait;
    }

    //Close the browser after each test method
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


}

