import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18Test extends BaseTest {

    @Test

    public void playSong() throws InterruptedException {

        //Pre-conditions
        navigateToPage();
        provideEmail("sade.harris@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        //Actions
        //Step 1 click play button
        clickPlay();
        //Verify Song is playing
        //Expected Result
        Assert.assertTrue(isSongPlaying());
    }


    public void clickPlay() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();
    }

    public boolean isSongPlaying() {
        WebElement pauseButtonDisplayed = driver.findElement(By.xpath("//span[@data-testid='pause-btn']"));
        return pauseButtonDisplayed.isDisplayed();
    }
}


