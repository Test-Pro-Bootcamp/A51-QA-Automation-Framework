import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    //public WebDriver driver = null;
    //public WebDriverWait wait = null;
    //public static Actions actions = null;
    //public  String url = "https://qa.koel.app/";

    //References start here
    public static WebDriver driver = null;
    public static String url = null;

    public static WebDriverWait wait = null;

    public static Actions actions = null;
    private static final ThreadLocal <WebDriver> threadDriver = new ThreadLocal<>();

    //References end here

    @BeforeSuite //The annotated method will run before all tests in this suit have run
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBrowser(String BaseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navigateToPage(BaseURL);
    }
    public static WebDriver getDriver(){
        return threadDriver.get();
    }
   /* @BeforeMethod //The annotated method will be run before all the test methods in the current class have been run.
    @Parameters({"BaseURL"})
    public void  launchBrowser(String BaseURL) throws MalformedURLException {

        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        actions = new Actions(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        url = BaseURL;
        navigateToPage();

    }*/
   /*    @BeforeMethod //The annotated method will be run before all the test methods in the current class have been run.
    //    @Parameters({"BaseURL"})
    //    public void  launchBrowser(String BaseURL) throws MalformedURLException {
    //        //Added ChromeOptions argument below to fix websocket error
    //        //ChromeOptions options = new ChromeOptions();
    //        //options.addArguments("--remote-allow-origins=*");
    //
    //        //driver = new ChromeDriver(options);
    //        //driver =new FirefoxDriver();
    //        driver = pickBrowser(System.getProperty("browser"));
    //        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //        driver.manage().window().maximize();
    //
    //        actions = new Actions(driver);
    //        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    //        url = BaseURL;
    //        navigateToPage();
    //
        }
     */
    @AfterMethod //The annotated method will be run after each test method
    public void closeBrowser(){
        driver.quit();
    }

    //region Helper Methods
    public static WebDriver lambdaTest() throws MalformedURLException {
        String userName= "khrys415";
        String authenticationKey = "bfsnu5KKEGMs0QSQRdf40hIJDebc2YS0YzL6NdFUa21pTeyo84";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "120.0");
        capabilities.setCapability("username", "khrys415");
        capabilities.setCapability("accessKey", "bfsnu5KKEGMs0QSQRdf40hIJDebc2YS0YzL6NdFUa21pTeyo84");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("project", "Untitled");

        return new RemoteWebDriver(new URL("https//"+userName+":"+authenticationKey+hub),capabilities);
    }
    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://localhost:4444";//"http://10.74.130.198:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgOptions = new EdgeOptions();
                edgOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgOptions);
            //Selenium Grid //command prompt: java -jar selenium-server-4.8.0.jar standalone
            case "grid-edge":// gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":// gradle clean test -Browser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":// gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browseName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }
    public void navigateToPage() {
        driver.get(url);
    }
    public void navigateToPage(String BaseURL){
        getDriver().get(BaseURL);
    }

    protected void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));//driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    protected void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));//driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    protected void clickSubmit() {
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))); //driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
    }
    //endregion
}