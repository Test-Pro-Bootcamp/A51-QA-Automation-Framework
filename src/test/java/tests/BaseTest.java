package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    public String url;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser (String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @DataProvider (name = "InvalidLoginData")
    public static Object[][] getValidDataFromDataProvider(){
        return new Object[][]{
                {"invalidemail@testpro.io", "invalidPassword"},
                {"",""}
        };
    }

    @DataProvider (name = "ValidLoginData")
    public static Object[][] getInvalidDataFromDataProvider(){
        return new Object[][]{
                {"alina.nikolaienko@testpro.io", "OPJKDUhA"}
        };
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();
    }

    public void loginIntoKoel(String email, String password){
        navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }
}