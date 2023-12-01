package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");
    By playlistsSection = By.id("playlists");
    By playlists = By.cssSelector("*[class='playlist playlist']");
    By addPlaylistButton = By.xpath("//*[@id='playlists']/h1/i");
    By newPlaylistButton = By.xpath("//*[@id='playlists']/nav/ul/li[1]");
    By playlistNameInput = By.xpath("//*[@id='playlists']/form/input");
    By editButton = By.cssSelector("[data-testid^='playlist-context-menu-edit']");
    By playlistRenamingInput = By.cssSelector("[data-testid='inline-playlist-name-input']");
    By additionSuccessElement = By.cssSelector("div[class='success show']");
    By deletePlaylistButton = By.cssSelector("button[class='del btn-delete-playlist']");
    By deletionSuccessElement = By.className("show");
    By avatarIcon = By.cssSelector("img.avatar");
    By profileName = By.cssSelector("a.view-profile>span");
    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
    public WebElement getPlaylistsSection() {
         return findElement(playlistsSection);
    }
    public List<WebElement> getPlaylists() {
         return getPlaylistsSection().findElements(playlists);
    }
    public WebElement getAddPlaylistButton() {
        return findElement(addPlaylistButton);
    }
    public WebElement getNewPlaylistButton() {
        return findElement(newPlaylistButton);
    }
    public WebElement getPlaylistNameInput() {
        return findElement(playlistNameInput);
    }
    public WebElement getEditButton() {
        return findElement(editButton);
    }
    public WebElement getPlaylistRenamingInput() {
        return findElement(playlistRenamingInput);
    }
    public WebElement getAdditionSuccessElement() {
        return findElement(additionSuccessElement);
    }
    public WebElement getDeletePlaylistButton() {
        return findElement(deletePlaylistButton);
    }
    public WebElement getDeletionSuccessElement() {
        return findElement(deletionSuccessElement);
    }
    public WebElement getAvatarIcon() {
        return findElement(avatarIcon);
    }
    public WebElement getProfileName() {
        return findElement(profileName);
    }
}
