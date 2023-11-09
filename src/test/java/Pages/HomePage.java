package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver dr){
        super(dr);
    }
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;

    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;

    @FindBy(css = "div.success.show")
    private WebElement renamePlaylistSuccessMsg;

    //By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    //By playlistNameField = By.cssSelector("[name='name']");
    //By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");

    public HomePage doubleClickPlaylist() {
        doubleClick(firstPlaylist);
        return this;
    }
    public HomePage enterNewPlaylistName(String playlistName){
        findElement(playlistNameField);
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        playlistNameField.sendKeys(playlistName);
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }
    public String getRenamePlaylistSuccessMsg(){
        return findElement(renamePlaylistSuccessMsg).getText();
    }
}
