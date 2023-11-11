import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework21 extends BaseTest{

    String newPlaylistName = "new name for playlist";

    @Test
    public void changeNameOfPlaylist(){

        String updatePlaylistMsg = "Updated playlist \"new name for playlist.\"";

        //login
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='name']")));
        //Double click
        doubleClickPlaylist();
        //Enter new name for playlist
        enterNewPlaylistName();
        //Assertion
        Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatePlaylistMsg);
    }

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        action.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement newNamePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        newNamePlaylist.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        newNamePlaylist.sendKeys(newPlaylistName);
        newNamePlaylist.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
