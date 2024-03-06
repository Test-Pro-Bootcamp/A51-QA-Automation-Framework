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
    @FindBy(css="img.avatar")
    WebElement userAvatarIcon;

    @FindBy(xpath="//*[@id='sidebar']/section[1]/ul/li[3]/a")
    WebElement allSongs;

    @FindBy(xpath="//*[@id='userBadge']/a[1]")
    WebElement profileLink;

    @FindBy(xpath="//*[@id='mainFooter']/div[1]/span/span[2]/i")
    WebElement playSong;

    @FindBy(xpath="//*[@id='mainFooter']/div[1]")
    WebElement playNextSong;

    @FindBy(css= "[data-testid='sound-bar-play']")
    WebElement soundBar;
    @FindBy(css="[href='registration']")
    WebElement registrationLink;


    public HomePage currentSongPlay(){
        click(playSong);
        return this;
    }
     public HomePage nextSongPlay(){
        click(playNextSong);
        return this;
     }

     public Boolean isSongPlaying(){
         return soundBar.isDisplayed();
     }

    public HomePage clickProfileLink(){
        click(profileLink);
        return this;
    }
    public HomePage clickAllSongs(){
        click(allSongs);
        return this;
    }


    public HomePage contextClickPlaylist(){
        contextClick(playlistExisting);
        return this;


    }
 public HomePage clickEdit(){
        click(editPlaylist);
        return this;
 }

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public HomePage enterNewPlaylistName(String playlistName){
        findElement(playlistNameField);
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistNameField.sendKeys("melodious album");
        playlistNameField.sendKeys(Keys.ENTER);
        return this;

    }
    public String getRenamePlaylistSuccessMsg(){
        return findElement (renamePlaylistSuccessMsg).getText();

    }

    public WebElement getRegistrationLink() {
        return findElement(registrationLink);
    }
}

