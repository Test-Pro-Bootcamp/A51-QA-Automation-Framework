import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public WebDriver driver ;
    //public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=* ");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod

    public void closeBrowser() {

        driver.quit();
    }



    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

    }

    public void navigateToLoginPage() {
        String url = "https://qa.koel.app";
        driver.get(url);
    }



//  public String generateRandomPlaylistName() {
//       return UUID.randomUUID().toString().replace("-", "");
//    }
}