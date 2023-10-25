import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emUser = driver.findElement(By.cssSelector("[type='email']"));
        emUser.sendKeys("kinjal.borad@testpro.io");

        WebElement emPswd = driver.findElement(By.cssSelector("[type='password']"));
        emPswd.sendKeys("Ganesh#123");

        WebElement emLogin = driver.findElement(By.cssSelector("[type='submit']"));
        emLogin.click();

        WebElement klSearch = driver.findElement(By.cssSelector("[type='search']"));
        klSearch.sendKeys("midnight");

        WebElement vAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        vAll.click();

        //driver.quit();
    }

}
