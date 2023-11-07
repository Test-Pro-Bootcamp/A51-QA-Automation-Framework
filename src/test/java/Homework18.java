import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException{
        //navigateToLoginPage();
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();
        Thread.sleep(2000);

        clickNextSong();
        clickPlay();

        WebElement result = driver.findElement(By.xpath("//img[@alt='Sound bars']"));
        Assert.assertTrue(result.isDisplayed());

    }

    public void clickNextSong(){
        WebElement nextSong = driver.findElement(By.xpath("//i[@title='Play next song']"));
        nextSong.click();
    }

    public void clickPlay(){
        WebElement play = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        play.click();
    }
}
