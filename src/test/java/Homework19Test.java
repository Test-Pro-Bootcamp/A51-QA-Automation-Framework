import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19Test extends BaseTest{

String expectedDeletionsMsg = "Deleted playlist \"wakeup.\"";
    @Test
public void deletePlaylist() throws InterruptedException {
        //Pre-Conditions
        navigateToPage();
        provideEmail("sade.harris@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        //Actions
        //Step1
        selectPlaylist();
        //Step2
        xPlaylistButton();
        //Step3 Verify Playlist has been deleted
        playlistDeletedMsg();
        Assert.assertEquals(playlistDeletedMsg(),expectedDeletionsMsg );


    }

public void selectPlaylist() {
    WebElement clickPlaylist = driver.findElement(By.xpath("//a[@href='#!/playlist/78943']"));
    clickPlaylist.click();
}
public void xPlaylistButton() throws InterruptedException {
    WebElement removePlaylist = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
    removePlaylist.click();
    Thread.sleep(2000);
}
public String playlistDeletedMsg() {
        WebElement deletedPlaylistMsgDisplayed = driver.findElement(By.cssSelector("div.success.show"));
        return deletedPlaylistMsgDisplayed.getText();
}
}
