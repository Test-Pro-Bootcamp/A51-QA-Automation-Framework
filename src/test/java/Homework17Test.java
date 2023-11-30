import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17Test extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        //pre-conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Actions
        //Step 1
                 String url = "https://qa.koel.app/";
                driver.get(url);

        //Step 2
                WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
                emailField.clear();
                emailField.sendKeys("sade.harris@testpro.io");
        //Step 3
                WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
                passwordField.clear();
                passwordField.sendKeys("te$t$tudent");

                WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
                submit.click();
        //Step 4
                WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
                search.clear();
                search.sendKeys("Episode2");
                WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
                viewAll.click();
        //Step 5
                WebElement selectFirstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//td[1]"));
                selectFirstSong.click();
        //Step6
                WebElement addToPlaylist = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
                addToPlaylist.click();
        //Step 7
                WebElement playlist = driver.findElement(By.xpath("//div[text()='Test Play'"));
                playlist.click();

                WebElement notification = driver.findElement(By.cssSelector("div.success.show"));

    }

}
