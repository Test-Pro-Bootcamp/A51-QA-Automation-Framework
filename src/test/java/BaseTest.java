import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void launchBrowser() {
        // Create ChromeOptions object to configure ChromeDriver
        ChromeOptions options = new ChromeOptions();

        // Add arguments to the ChromeOptions object
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");

        // Set experimental options to exclude certain switches
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // Create a new instance of ChromeDriver with the configured options
        driver = new ChromeDriver(options);

        // Set the implicit wait time for the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the specified URL in the Chrome browser
        driver.get("https://qa.koel.app/");
    }


    @AfterMethod
    public void closeBrowser() {
        // Quit the driver, closing all associated windows
        driver.quit();
    }

    public WebDriver driver;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    public void logIn(String email, String password) throws InterruptedException{
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys(email);
        Thread.sleep(2000);
        
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);
        Thread.sleep(2000);
        
        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }
    
    public void enterAllSongs() throws InterruptedException{
        WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        Thread.sleep(5000);
    }
    
    public void selectSong() throws InterruptedException{
        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']"));
        Thread.sleep(5000);
        song.click();
    }
    
    public void enterButtonPLaySong(){
        WebElement buttonPLaySong = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        Actions actions = new Actions(driver);
        WebElement buttonPlaySong = null;
        actions.click(buttonPlaySong).perform();
    }


    }
