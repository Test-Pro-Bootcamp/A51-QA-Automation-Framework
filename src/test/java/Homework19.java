import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class Homework19 extends BaseTest {
    @Test
    @Parameters({"BaseUrl"})
    public void deletePlaylist(String baseUrl) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

        WebElement loginField = driver.findElement(By.xpath("//input[@type='email']"));
        String email = "iryna.berezkina@testpro.io";
        loginField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        String password = "pnPGl1hk";
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement addPlaylistButton = driver.findElement(By.xpath("//*[@id='playlists']/h1/i"));
        addPlaylistButton.click();

        WebElement newPlaylistButton = driver.findElement(By.xpath("//*[@id='playlists']/nav/ul/li[1]"));
        newPlaylistButton.click();

        String playlistName = "My Playlist";
        WebElement playlistNameInput = driver.findElement(By.xpath("//*[@id='playlists']/form/input"));
        playlistNameInput.sendKeys(playlistName);
        playlistNameInput.sendKeys(Keys.RETURN);

        WebElement additionSuccess = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(additionSuccess.isDisplayed());

        WebElement removeButton = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        removeButton.click();

        WebElement removalSuccess = driver.findElement(By.className("show"));
        Assert.assertTrue(removalSuccess.isDisplayed());
    }
}
