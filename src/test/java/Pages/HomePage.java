package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".avatar")
    private WebElement userAvatarIcon;

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firsPlaylist;

    @FindBy(css = "input[name='name']")
    private WebElement playlistInputField;

    @FindBy(css = ".fa-plus-circle")
    private WebElement addNewPlaylist;

    @FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlaylistBtn;

    @FindBy(css = ".show.success")
    private WebElement notification;

    @FindBy(css = ".songs")
    private WebElement allSongs;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement chooseCreateNewPlaylist;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean getUserAvatar() {
        return userAvatarIcon.isEnabled();
    }

    public HomePage chooseFirstPlaylist() {
        firsPlaylist.click();
        return this;
    }

    public HomePage deletePlaylist() {
        deletePlaylistBtn.click();
        return this;
    }

    public boolean notificationText() {
        findElement(notification);
        return notification.isDisplayed();
    }

    public HomePage searchField() {
        searchField().click();
        return this;
    }

    public HomePage provideViewAll() {
        provideViewAll().click();
        return this;
    }

    public HomePage choiceSong() {
        choiceSong().click();
        return this;
    }

    public HomePage addToList() {
        addToList().click();
        return this;
    }

    public HomePage choiceList() {
        choiceList().click();
        return this;
    }

    public boolean[] notificationMessage() {
        notificationMessage();
        return new boolean[0];
    }
}