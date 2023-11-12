package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    //public HomePage(WebDriver givenDriver) {
       //super(givenDriver);
   // }

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement emptyPlaylistLocator;
    
    @FindBy(css = "#playlistWrapper > header > div.song-list-controls > span > button")
    private WebElement deletePlaylistLocator;
    @FindBy(css = "div.success.show")
    private WebElement notificationMsgLocator;
    @FindBy(css = "your-avatar-selector")
    private WebElement avatarLocator;

    //Constructor for HomePage class
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    //Method to open the playlist
    public void openPlaylist(){
        findElement(emptyPlaylistLocator);
        click(emptyPlaylistLocator);
    }
    //Method to click on the delete playlist button
    public void clickDeletePlaylistBtn(){
        findElement(deletePlaylistLocator);
        click(deletePlaylistLocator);
    }
    //Method to get the text of the notification message
    public String getDeletedPlaylistMsg(){
        findElement(notificationMsgLocator);
        return notificationMsgLocator.getText();
    }
    //Method to check if the avatar selected is displayed
    public boolean isAvatarDisplayed(){
        findElement(avatarLocator);
        return avatarLocator.isDisplayed();
    }


    }


