import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }


    @Test
    public void loginValidEmailValidPassword() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //precondition
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //step 1
        String url = "https://qa.koel.app";
        driver.get(url);

        //step 2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("jguy1@stny.rr.com");

        //step 3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        //step 4
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        //expected result
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));

        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();
    }


    @Test
    public void loginInvalidEmailValidPassword() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("jguy1@testpro.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));

        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();
    }


    @Test
    public void loginValidEmailNoPassword() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("inout[type'email']"));
        emailField.clear();
        emailField.sendKeys("jguy1@stny.rr.com");

        //NO PASSWORD!

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));

        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();

    }




}
