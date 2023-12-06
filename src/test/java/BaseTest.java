import com.beust.jcommander.Parameter;
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
import java.util.HashMap;

import static java.sql.DriverManager.getDriver;

public class BaseTest {

    public static WebDriver driver = null;
    public String url = null;
    public static final ThreadLocal<WebDriver>threadDriver = new ThreadLocal<>();
    public WebDriverWait wait;
    public Actions actions;

    @BeforeSuite

    static void setupClass() {
            //WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
      public void launchBrowser(String BaseURL) throws MalformedURLException{

      threadDriver.set(pickBrowser(System.getProperty("browser")));
      getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         url = BaseURL;
        navigateToPage(BaseURL);
    }
public static WebDriver getDriver(){
        return threadDriver.get();

}
    public WebDriver pickBrowser(String browser)throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL= "http://192.168.86.147:4444";

        switch(browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver= new FirefoxDriver();

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins-*");
                edgeOptions.addArguments("--disable-notifications");
                return driver= new EdgeDriver(edgeOptions);

            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                        return driver =new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                      return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "cloud ":
                return lambdaTest();


            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                return driver = new ChromeDriver(options);
        }

    }
//public WebDriver lamdaTest()throws MalformedURLException{
//        String username="capri.aparajita";
//        String authKey = "JAYg1AzwrPdpE7aQYj5BszdwwdNQYSI6hCQvPsidCqT22xlCJ1";
//        String hub ="@hub.lambdatest.com/wd/hub";
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform" , "Windows11");
//        caps.setCapability("browserName" , "Chrome");
//        caps.setCapability("version" , "119.0.");
//        caps.setCapability("resolution" , "12024x768");
//        caps.setCapability("platform" , "Windows11");
//        caps.setCapability("platform" , "Windows11");
//        caps.setCapability("platform" , "Windows11");
//
//        return null;
//}
    public WebDriver lambdaTest()throws MalformedURLException{
        String hubURL = "https://hub.lambdatest.com/wd/hub" ;

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("120.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "capri.aparajita");
        ltOptions.put("accessKey", "JAYg1AzwrPdpE7aQYj5BszdwwdNQYSI6hCQvPsidCqT22xlCJ1");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL),browserOptions);
    }

    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();

    }
    public void navigateToPage(String BaseURL) {
        //String url ="https//qa.koel.app";
        driver.get(BaseURL);
    }
    public void provideEmail(String email){
        WebElement emailField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);

    }
    public void providePassword(String password){
        WebElement passwordField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        WebElement submit= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
        submit.click();
    }





}