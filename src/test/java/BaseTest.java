import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;




public class BaseTest {
    //added for cloud test


    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    //added for cloud test
    private WebDriver driver;

    //added for cloud test
    public static WebDriver getThreadLocal(){
        return THREAD_LOCAL.get();
    }

    /*public static WebDriver getDriver(){
        return threadDriver.get();
    }*/

    public static String url;
    public WebDriverWait wait;
    public static Actions actions = null;


    @BeforeMethod
    @Parameters({"BaseURL"})
    //added for cloud test
    public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        THREAD_LOCAL.get().manage().window().maximize();
        THREAD_LOCAL.get().manage().deleteAllCookies();
        getThreadLocal().get(baseURL);
        System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is: " + getThreadLocal());
    }
    //added for cloud test
    public WebDriver lambdaTest() throws MalformedURLException{
        String username = "zhanna.ivanova";
        String authkey = "jEo67fsZEJk6ilP8WkNG23XjKbBefaiaJp7WunaYYIjkINmlOG";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "110.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG with Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testing");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://10.2.127.17:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge  ");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(optionsChrome);
        }
    }

    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
}