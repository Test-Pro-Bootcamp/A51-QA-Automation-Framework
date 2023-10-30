import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {

    public WebDriver driver;

    public String url = "https//qa.koel.app";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl){
//Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToLoginPage(BaseUrl);

        //url = BaseUrl;
        //driver.get(url);
    }
    @AfterMethod
    public void closeBrowser(){driver.quit();}


    public void navigateToLoginPage() {
        driver.get(url);
    }

    public void navigateToLoginPage(String BaseUrl) {driver.get(BaseUrl);}


    public provideEmail(String email) throws InterruptedException{
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(2000);
    }

    public void providePassword(String password) throws InterruptedException{
        WebElement passwordField = driver.findELement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
        Thread.sleep(2000);
    }

    public void clickSubmit() throws InterruptedException{
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        Thread.sleep(2000);

    }
}