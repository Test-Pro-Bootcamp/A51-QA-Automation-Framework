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
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public String url = "https://qa.koel.app/";

    public WebDriverWait wait;

     Actions actions;


    @BeforeSuite
    static void setupClass() {
       // WebDriverManager.chromedriver().setup();
       //   WebDriverManager.firefoxdriver().setup();
          WebDriverManager.safaridriver().setup();

    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
       // ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--remote-allow-origins=*");
       // driver = new ChromeDriver(options);
          driver = pickBrowser(System.getProperty("browser"));
       // driver = new FirefoxDriver();
        //driver = new SafariDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.manage().window().maximize();
        url = BaseURL;
        navigateToLoginPage();
    }

    public static WebDriver pickBrowser(String browser){
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "Safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);

        }
    }
    @AfterMethod
    public void closeBrowser(){
       driver.quit();
    }

    public void navigateToLoginPage(){
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
}