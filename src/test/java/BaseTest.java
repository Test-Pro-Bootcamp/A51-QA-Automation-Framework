import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;

public class BaseTest {

   public WebDriver driver;


   public String url="https://qa.koel.app";
   public void logIn(String email, String password){
      WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
      emailField.sendKeys("hassan.mahim@testpro.io");

      WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
      passwordField.sendKeys("YOUSSEf2017$");

      WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
      submitButton.click();
   }
public void enterAllSongs() throws InterruptedException{
      WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
      Thread.sleep(1000);
      allSongs.click();
}
public void selectSong() throws InterruptedException{
      WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']"));
      Thread.sleep(1000);
      song.click();
}
public void enterButtonPlaySong(){
      WebElement buttonPlaySong = driver.findElement(By.xpath("//span[@title='play or resume']"));
      Actions actions = new Actions(driver);
      actions.click(buttonPlaySong).perform();
 }
 public boolean isDisplayedPlayingSong(){
       WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
       return songIsPlaying.isDisplayed();
 }
}