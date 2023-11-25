import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
     public Actions actions;
     public String url;
     //stores an instance of WebDriver for each thread during test execution
     private final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
     //return the current instance of WebDriver associated with the current thread
     public WebDriver getDriver() {
         return threadDriver.get();
     }
    //@BeforeSuite
    //static void setupClass() {
       // WebDriverManager.chromedriver().setup();
       //   WebDriverManager.firefoxdriver().setup();
       // WebDriverManager.safaridriver().setup();


    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBrowser(String BaseURL) throws MalformedURLException{
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        navigateToLoginPage(BaseURL);
    }
    /*@BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
          driver = pickBrowser(System.getProperty("browser"));
          wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          actions = new Actions(driver);
          driver.manage().window().maximize();
          navigateToLoginPage(BaseURL);
    }*/
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.15:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            //gradle clean test -Dbrowser=MicrosoftEdge
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
//                edgeOptions.addArguments(new String[]{"--remote-allow-origins=*", "--disable-notifications", "--start-maximized"});
                return driver = new EdgeDriver();
            //gradle clean test -Dbrowser=grid-edge
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            //gradle clean test -Dbrowser=grid-firefox
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            //gradle clean test -Dbrowser=grid-chrome
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
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


    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "arleisha.strauder";
        String authKey = "43H824kbpjoBxVgAN6EZ8YunDXKel9uETZJTEZazwJDZWntFCv";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "macOS Sonoma");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "119.0");
        caps.setCapability("resolution", "1280x800");
        caps.setCapability("build", "TestNG with Java");
        caps.setCapability("name", BaseTest.class.getName());
        caps.setCapability("plugin", "java-testNG");
        return new RemoteWebDriver(new URL("https://" +username+ ":" +authKey + hub), caps);
    }

    /*@AfterMethod
    public void closeBrowser(){
       driver.quit();
    }*/
    @AfterMethod
    //close the current instance and remove it from grid testing
    public void closeBrowser(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public void navigateToLoginPage(String BaseURL){
        driver.get(url);
    }

    public void provideEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
       // WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void providePassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit(){
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
    public void clickAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }
    public void provideCurrentPassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
    public void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }
    public void provideProfileName(String randomName) {
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileName.clear();
        profileName.sendKeys(randomName);
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public void isAvatarDisplayed() {
//        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

}