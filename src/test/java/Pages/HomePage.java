package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locator for test method renamePlaylist
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='name']");
    By renamePlaylistSuccessMSG = By.cssSelector("div.success.show");

    By userAvatarIcon = By.cssSelector("img.avatar");

    //Locators for playsong
    By nextSong = By.xpath("//i[@title='Play next song']");
    By playSong = By.xpath("//span[@title='Play or resume']");
    By resultIcon = By.xpath("//img[@alt='Sound bars']");

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
//helper methods for test rename playlist
    public void doubleClickPlayList(){
        doubleClick(firstPlaylist);
    }
    public void enterNewPlayListName(String playListName){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playListName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public String getRenamePlayListSuccessMsg(){
        return findElement(renamePlaylistSuccessMSG).getText();
    }

//helper methods for test play song
public void clickNextSong(){
    findElement(nextSong).click();
}

    public void clickPlay(){
        findElement(playSong).click();
    }
    public WebElement getResult(){
        return findElement(resultIcon);
    }
}

