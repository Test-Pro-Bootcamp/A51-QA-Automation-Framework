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


public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    public WebElement notificationMsg;

    public String url = "https://qa.koel.app";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) {
        //Added ChromeOptions argument to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Open Chrome Browser
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        url = BaseUrl;
        navigateToPage();

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    //Prerequisites
    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        try {
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
            emailField.sendKeys(email);
        } catch (NullPointerException npe) {
        }
    }

    public void providePassword(String password) {
        try {
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
            passwordField.clear();
            passwordField.sendKeys(password);
        } catch (NullPointerException npe) {
        }
    }

    public void clickSubmit() {
        try {
            WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
            submit.click();
        } catch (NullPointerException npe) {
        }
    }

    //Step 1 - Open PLaylist
    public void openPlaylist() {
        try {
            WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
            emptyPlaylist.click();
        } catch (NullPointerException npe) {
        }
    }

    //Step 2 - Delete Playlist
    public void clickDeletePlaylistBtn() {
        try {
            WebElement deletePLaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
            deletePLaylist.click();
        } catch (NullPointerException npe) {
        }
    }

    //Step 3 - Verify Playlist has been deleted
    public String getDeletedPlaylistMsg() {

        //try {
            notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //} catch (NullPointerException npe) {
        //}
            return notificationMsg.getText();

    }
}



