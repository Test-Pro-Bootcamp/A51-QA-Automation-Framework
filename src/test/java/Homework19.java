import com.fasterxml.jackson.core.json.PackageVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeleteMessage = "Deleted playlist \"A51 TEST playlist 1.\"";

        provideEmail("jguy1@stny.rr.com");
        providePassword("te$t$tudent");
        clickSubmit();
        selectPlaylistToDelete();
        clickRedDeleteButton();
        deleteNotificationText();

        Assert.assertEquals(deleteNotificationText(), expectedPlaylistDeleteMessage);

    }
        //select playlist to delete and click on it
    public void selectPlaylistToDelete() {
        WebElement playListToDelete = driver.findElement(By.cssSelector(".playlist:nth-child(4)"));
        playListToDelete.click();
    }

        //navigate to Red Button 'X PLAYLIST' and click on it
    public void clickRedDeleteButton() throws InterruptedException {
        WebElement redDeleteButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        redDeleteButton.click();
        Thread.sleep(2000);
    }

        //verify that the list has been deleted via pop-up message
    public String deleteNotificationText() {
        WebElement deleteNotification = driver.findElement(By.cssSelector("div.success.show"));
        return deleteNotification.getText();

    }

}

// This comment is has nothing to do with this code!