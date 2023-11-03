import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.thread.IThreadWorkerFactory;

import javax.swing.*;
import java.time.Duration;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement loginField = driver.findElement(By.xpath("//input[@type='email']"));
        String email = "iryna.berezkina@testpro.io";
        loginField.sendKeys(email);
        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        String password = "pnPGl1hk";
        passwordField.sendKeys(password);
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement albumThumb = driver.findElement(By.className("album-thumb-wrapper"));
        Actions hover = new Actions(driver);
        hover.moveToElement(albumThumb).perform();
        Thread.sleep(2000);
        albumThumb.click();
        Thread.sleep(2000);

        WebElement soundBar = driver.findElement(By.className("bars"));
        Assert.assertEquals(soundBar.isDisplayed(), true);
    }
}
