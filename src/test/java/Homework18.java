import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);

        clickPlaySong();
        playButton();
        WebElement soundbar = driver.findElement(By.cssSelector("div[class='bars']"));
        Assert.assertTrue(soundbar.isDisplayed());

    }

    public void clickPlaySong(){
        WebElement playnextSong  = driver.findElement(By.cssSelector("[title='Play next song']"));
        playnextSong.click();
    }

    public void playButton(){
        WebElement buttonPlay = driver.findElement(By.cssSelector("[title='Play or resume']"));
        buttonPlay.click();
    }

}
