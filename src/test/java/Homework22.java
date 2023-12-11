import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homework22Page;

public class Homework22 extends BaseTest{

    String newPlaylistName = "HW 22 - Sample Edited Playlist";


    @Test
    public void renamePlaylist() throws InterruptedException {
        //Prerequisite at least one user created playlist
        String updatedPlaylistMsg = "Updated playlist \"HW 22 - Sample Edited Playlist.\"";

        Homework22Page hw22Page = new Homework22Page(driver);

        hw22Page.provideEmail("demo@class.com");
        hw22Page.providePassword("te$t$tudent");
        hw22Page.clickSubmitBtn();

        doubleClickPlaylist();
        enterNewPlaylistName();

        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }
    @Test
    public void renamePlaylistUsingFluentInterfaces() throws InterruptedException {
        //Prerequisite at least one user created playlist
        String updatedPlaylistMsg = "Updated playlist \"HW 22 - Sample Edited Playlist.\"";

        Homework22Page hw22Page = new Homework22Page(driver);

        hw22Page.provideEmail("demo@class.com").providePassword("te$t$tudent").clickSubmitBtn();//Using fluent interfaces

        doubleClickPlaylist();
        enterNewPlaylistName();

        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }

    private void doubleClickPlaylist() {
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playListElement).perform();
    }

    private void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //clear() does not work, element has an attribute of "required"
        //workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));

        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    private String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }


}
