import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist()  {
        String expectedPlaylistDeletedNotification = "Deleted playlist";

        navigateToLoginPage();
        provideEmail("sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
        clickPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistNotification().contains(expectedPlaylistDeletedNotification));



    }

    public void clickPlaylist() {
        WebElement myPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        myPlaylist.click();
    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='del btn-delete-playlist']")));
        deletePlaylist.click();


    }
    public String getDeletedPlaylistNotification(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        return notification.getText();
    }
}