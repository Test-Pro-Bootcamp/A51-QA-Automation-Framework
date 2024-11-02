import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18  extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        logIn("hassan.mahim@testpro.io", "YOUSSEf2017$");
        enterAllSongs();
        selectSong();
        enterButtonPlaySong();
        Assert.assertTrue(isDisplayedPlayingSong());
    }


}



