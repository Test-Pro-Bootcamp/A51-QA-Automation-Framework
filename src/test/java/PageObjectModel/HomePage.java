package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='name']");
    public void enterNewPlaylistName(String playlistName){
        By PlaylistNameField = null;
        findElement(PlaylistNameField).sendKeys(playlistName);
        findElement(PlaylistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        findElement(PlaylistNameField).sendKeys(playlistName);
        findElement(PlaylistNameField).sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String playlistName){
        By newPlaylist = By.xpath("//a[text()='"+playlistName+"']");
        return findElement(newPlaylist).isDisplayed();
    }


}
