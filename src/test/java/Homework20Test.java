import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20Test extends BaseTest{

String expectedDeletionsMsg = "Deleted playlist \"wakeup.\"";
    @Test
public void deletePlaylist() {
        //Pre-Conditions
        navigateToPage();
        provideEmail("sade.harris@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
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
        WebElement clickPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#!/playlist/80965']")));
        clickPlaylist.click();
}
public void xPlaylistButton()  {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        deletePlaylist.click();
}
public String playlistDeletedMsg() {
      // WebElement deletedPlaylistMsgDisplayed = driver.findElement(By.cssSelector("div.success.show"));
        WebElement deletedPlaylistMsgDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deletedPlaylistMsgDisplayed.getText();
}
}
