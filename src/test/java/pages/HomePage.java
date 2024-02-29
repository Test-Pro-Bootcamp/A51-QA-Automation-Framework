package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


    @FindBy(xpath="//*[@id='playlists']/h1/i")
    WebElement playlistCreateOptions;


    @FindBy(css="[data-testid='playlist-context-menu-create-smart']")
    WebElement selectNewSmartPlaylistOption;



    @FindBy(css="div.success.show")
    WebElement renamePlaylistSuccessMsg;


    public HomePage clickPlaylist(){
        click(playlistCreateOptions);
        return this;
    }
    public HomePage clickSmartPlaylist(){
        click(selectNewSmartPlaylistOption);
        return this;


    }
// public HomePage clickEdit(){
//        click(editPlaylist);
//        return this;


//    public WebElement getUserAvatar(){
//        return findElement(userAvatarIcon);
//    }




    public String getRenamePlaylistSuccessMsg(){
        return findElement (renamePlaylistSuccessMsg).getText();

    }
}

