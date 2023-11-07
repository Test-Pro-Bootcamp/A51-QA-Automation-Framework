import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test

    public void playSong () throws InterruptedException {
        navigateToLoginPage();
        provideEmail("faizan.khan@testpro.io");
        providePassword("master21");
        clickSubmit();
        Thread.sleep(2000);
        clickPlay();
        Assert.assertTrue(songIsPlaying());

    }
public void clickPlay () {
    WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
    WebElement skipForwardBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
    playButton.click();
    skipForwardBtn.click();
    }
public boolean songIsPlaying () {
    WebElement soundBar = driver.findElement(By.xpath("//div//img[@alt='Sound bars']"));
return soundBar.isDisplayed();
}



}
