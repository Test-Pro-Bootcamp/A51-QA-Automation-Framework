import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {


    @Test
    public void playSong(){

        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
    public void clickPlay(){
        WebElement playNextBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        WebElement playBtn = driver.findElement(By.cssSelector("[class='album-thumb-wrapper']"));

        playNextBtn.click();
        playBtn.click();
    }
    public boolean isSongPlaying() {
       WebElement soundBar = driver.findElement(By.cssSelector("[alt='Sound bars']"));
       return soundBar.isDisplayed();
    }

}
