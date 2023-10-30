import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong(){
        navigateToLoginpage();
        provideEmail("Demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        playNextSong();
        clickPlay();

        Assert.assertTrue(isSoundPlaying());
        closeBrowser();


    }

    private boolean isSoundPlaying() {
        WebElement soundBar=driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }


    public void clickPlay() {
        WebElement playButton =driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playButton.click();
    }

    private void playNextSong() {
        WebElement playNextButton= driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNextButton.click();
    }

}
