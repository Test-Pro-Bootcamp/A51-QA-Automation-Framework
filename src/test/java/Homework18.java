import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test(priority = 1, description = "Play song and validate is is playing")
    public void playSong() throws InterruptedException{
        logIn("adam.johnson@testpro.io", "1Te$t$tudent");

        enterAllSongs();
        selectSong();
        enterButtonPLaySong();

        Assert.assertTrue(isDisplayedPlayingSong());

       // provideEmail("adam.johnson@testpro.io");
        //providePassword("1Te$t$tudent");
        //clickSubmit();
        //clickPlay();
        //Assert.assertTrue(isSongPLaying());
    }


    public void clickPlay(){
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNextButton.click();
        playButton.click();
    }
    public boolean isDisplayedPlayingSong(){;
        WebElement songIsPLaying = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return songIsPLaying.isDisplayed();
    }
}
