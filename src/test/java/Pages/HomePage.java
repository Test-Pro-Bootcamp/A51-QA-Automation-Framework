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


    @FindBy(xpath = "//*[@id='playlists']/ul/li[4]")
    WebElement playlistExisting;

    //By editPlaylist = By.xpath("//*[@id='playlists']/ul/li[4]/nav/ul/li[1]");
    @FindBy(xpath="//*[@id='playlists']/ul/li[4]/nav/ul/li[1]")
    WebElement editPlaylist;
    //By playlistNameField =By.cssSelector("[name='name']");
    @FindBy(css="[name='name']")
    WebElement playlistNameField;
    //By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");
    @FindBy(css="div.success.show")
    WebElement renamePlaylistSuccessMsg;

    public HomePage contextClickPlaylist(){
        contextClick(playlistExisting);
        return this;


    }
    public HomePage clickEdit(){
        click(editPlaylist);
        return this;
    }


    public HomePage enterNewPlaylistName(String playlistName){
        findElement(playlistNameField);
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistNameField.sendKeys("Sanjeelas Playlist");
        playlistNameField.sendKeys(Keys.ENTER);
        return this;

    }
    public String getRenamePlaylistSuccessMsg(){
        return findElement (renamePlaylistSuccessMsg).getText();

    }
}