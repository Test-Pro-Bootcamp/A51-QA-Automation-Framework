package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".avatar")
    private WebElement userAvatarIcon;

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;

    @FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlaylistBtn;

    @FindBy(css = ".show.success")
    private WebElement notification;

    public boolean HomePage(WebDriver givenDriver){
        super(givenDriver);

        public boolean getUserAvatar(){
            return userAvatarIcon.isEnabled();
        }

        public HomePage chooseFirstPlaylist(){
            firstPlaylist.click();
            return this;

        }
        public HomePage deletePlaylist(){
            deletePlaylistBtn.click();
            return this;
        }

        public boolean notificationText(){
            findElement(notification);
            return notification.isDisplayed();
        }


    }























}
