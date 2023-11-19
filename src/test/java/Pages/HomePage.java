package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By clickFirstPlaylist = By.cssSelector(".playlist:nth-child(3)");

    private By playlistNameField = By.cssSelector("[name='name']");

    private By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");

    public void doubleClickPlaylist() {
        doubleClick(clickFirstPlaylist);

    }

    public void enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);

    }

    public String getRenamePlaylistSuccessMsg() {
        return findElement(renamePlaylistSuccessMsg).getText();

    }

}