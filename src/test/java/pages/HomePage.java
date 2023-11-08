package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By userAvatarIcon = By.cssSelector("img.avatar");
    By existingPlaylist = By.xpath("//*[@id='playlists']/ul/li[4]");
    By editPlaylist = By.xpath("//*[@id='playlists']/ul/li[4]/nav/ul/li[1]");
    By playlistNameField =By.cssSelector("[name='name']");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");

    public void contextClickPlaylist(){
        contextClick(existingPlaylist);
    }
 public void clickEdit(){
     click(editPlaylist);
 }

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public void enterNewPlaylistName(String playlistName){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys("melodious album");
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg(){
        return findElement(renamePlaylistSuccessMsg).getText();
    }
}

