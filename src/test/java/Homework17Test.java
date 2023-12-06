import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;




public class Homework17Test extends BaseTest {

    @Test

public void addSongToPlaylist() throws InterruptedException {

    String songAddedMessage = "Added 1 song into \"Test Play\" ";

    //Pre-Condition
    navigateToPage();
    provideEmail("sade.harris@testpro.io");
    providePassword("te$t$tudent");
    clickSubmit();
    Thread.sleep(2000);

        Assert.assertEquals(getAddToPlaylistSuccessMsg(),songAddedMessage);
//Step 1
    WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
    search.clear();
    search.sendKeys("Episode2");
    Thread.sleep(2000);

//Step 2
    WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
    viewAll.click();
    Thread.sleep(2000);

//Step 3
    WebElement selectFirstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//td[1]"));
    selectFirstSong.click();
    Thread.sleep(2000);

//Step 4
    WebElement addToPlaylist = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
    addToPlaylist.click();
    Thread.sleep(2000);

//Step 5

    WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Play')]"));
    playlist.click();
}
public String getAddToPlaylistSuccessMsg () {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();

    }

}







