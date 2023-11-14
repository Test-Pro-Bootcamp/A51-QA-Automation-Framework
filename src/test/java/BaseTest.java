import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.time.Instant;

import java.util.function.Function;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    Actions actions;


    //Setup WebDriverManager for ChromeDriver
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    //Launch Chrome browser and navigate to BaseUrl
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) throws InterruptedException, MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);



    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.16.33.228:4444";


        switch (browser){
            case "Safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "FirefoxDriver":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            //Selenium Grid
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
                return driver = new ChromeDriver(options);

        }
    }

    //Close the browser after each test method
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


}

