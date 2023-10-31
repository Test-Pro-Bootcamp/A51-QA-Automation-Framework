import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {

    public WebDriver driver;

    public String url = "https://qa.koel.app";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) throws InterruptedException{
        //Added ChromeOptions argument to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Open Chrome Browser
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseUrl;
        navigateToPage();
        Thread.sleep(3000);
    }
    @AfterMethod
    public void closeBrowser(){driver.quit();}

    //Prerequisites
    public void navigateToPage(){
        driver.get(url);
    }

    public void provideEmail(String email) throws InterruptedException{
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys(email);
        Thread.sleep(3000);
    }

    public void providePassword(String password) throws InterruptedException{
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
        Thread.sleep(3000);
    }

    public void clickSubmit(){
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
    //Step 1 - Open PLaylist
    public void openPlaylist() throws InterruptedException {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
        Thread.sleep(3000);
    }
    //Step 2 - Delete Playlist
    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePLaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePLaylist.click();
        //Thread.sleep(2000);
    }
    //Step 3 - Verify Playlist has been deleted
    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }

}