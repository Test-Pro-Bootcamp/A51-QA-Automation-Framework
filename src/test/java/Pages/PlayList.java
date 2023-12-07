package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PlayList extends BasePage {
    public PlayList(WebDriver givenDriver) {
        super(givenDriver);
    }
    String newPlaylistName = "new name for playlist";

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
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
