package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AllSongsTests extends BaseTest {
    @Test
    public void countSongsInPlaylist() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("");

        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);
        //WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        //Assert.assertTrue(avatar.isDisplayed());
        driver.quit();
    }



}
