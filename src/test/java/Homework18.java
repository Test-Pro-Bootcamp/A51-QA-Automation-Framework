import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework18 extends BaseTest {


    @Test
    public void playSong() throws InterruptedException {

        navigateToPage();
        provideEmail("jguy1@stny.rr.com");
        providePassword("te$t$tudent");
        clickSubmit();

        clickPlay();

        Assert.assertTrue(songPlaying());
    }

    public void clickPlay() throws InterruptedException {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        Thread.sleep(2000);
        playButton.click();

    }

    public boolean songPlaying() {
        WebElement soundBarMoving = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBarMoving.isDisplayed();
    }

}
