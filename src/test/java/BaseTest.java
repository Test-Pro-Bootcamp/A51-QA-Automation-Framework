import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import static java.sql.DriverManager.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;




public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    //public static WebDriver driver;
    public String url ="https://qa.koel.app";
    public static Actions actions = null;



    //Setup WebDriverManager for ChromeDriver
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    //Launch browser(s) and navigate to BaseUrl
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public WebDriver launchBrowser(String BaseUrl) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.manage().window().maximize();
        navigateToLoginPage(BaseURL);
        }

        public static WebDriver pickBrowser(String browser) throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            String gridURL = "http://10.16.33.228:4444";

            switch (browser){
                case "Safari":
                    WebDriverManager.safaridriver().setup();
                    return driver = new SafariDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return driver = new FirefoxDriver();

                //Selenium Grid
                case "grid-safari": //gradle clean test -Dbrowser=grid-safari
                    caps.setCapability("browser", "Safari");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

                case "grid-firefox": //gradle clean test -Dbrowser=grid-firefox
                    caps.setCapability("browser", "firefox");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

                case "grid-chrome": // gradle clean test -Dbrowser=grid-chrome
                    caps.setCapability("browserName", "chrome");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    return driver = new ChromeDriver(options);
            }
        }

    //Close the browser after each test method
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


}

