import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import java.time.Duration;

public class Homework17 extends BaseTest  {
    @Test
    public void addSongToPlaylist () throws InterruptedException  {
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

        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        String songName = "Dark Days";
        searchField.sendKeys(songName);
        Thread.sleep(2000);

        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);

        WebElement section = driver.findElement(By.xpath("//section[@id='songResultsWrapper']"));
        WebElement firstSong = section.findElement(By.xpath(".//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);

        WebElement addTo = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));
        addTo.click();
        Thread.sleep(2000);

        WebElement playlistsSection = driver.findElement(By.xpath("//section[@class='existing-playlists']"));
        WebElement myPlaylist = playlistsSection.findElement(By.xpath("(//ul/li)[1]"));
        myPlaylist.click();
        Thread.sleep(2000);

        // ??????
        // There is no notification on the page after the song was added to a playlist, clarification needed.
    }
}
