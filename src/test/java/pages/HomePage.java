package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.UUID;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = "img.avatar")
    private WebElement avatar;
    //By userAvatarIcon = By.cssSelector("img.avatar");

    @FindBy (css = "[type='search']")
    private WebElement searchElement;

    @FindBy (css = ".songs")
    private WebElement allSongs;

    @FindBy (css = ".albums")
    private WebElement albums;

    @FindBy (xpath = "//*[@id=\"userBadge\"]//span[@class='name']")
    private WebElement profileIcon;

    @FindBy (css = ".fa.fa-plus-circle.create")
    public WebElement addPlaylistButton;

    @FindBy (css = "#playlists > nav > ul > li:nth-child(1)")
    public WebElement newPlaylistButton;

    @FindBy (xpath = "//*[@id=\"playlists\"]/nav/ul/li[2]")
    public WebElement newSmartPlaylistButton;

    @FindBy (css = "#playlists > form > input")
    public WebElement inputField;

    @FindBy (xpath = "//*[@id='playlists']/ul/li[4]/a")
    public WebElement newlyCreatedPlaylist;


    @FindBy (css = "div.success.show")
    WebElement notificationMessage;

    //@FindBy (css = "#mainFooter > div.side.player-controls > span > span.album-thumb")
    @FindBy (xpath = "//*[@id='mainFooter']/div[1]/span/span[1]")
    public WebElement playButton;

    @FindBy (xpath = "//*[@id=\"mainFooter\"]/div[1]/span/span[2]/i")
    public WebElement playButtonActive;

    @FindBy (xpath = "//*[@id=\"mainFooter\"]/div[2]/div[2]/div/button[1]/div")
    public WebElement equalizerButton;

    @FindBy (xpath = "//*[@id='progressPane']/p/a[1]")
    public WebElement artistPlaying;

    @FindBy (xpath = "//*[@id='progressPane']/p/a[2]")
    public WebElement albumPlaying;

    public void clickPlayButton(){
        wait.until(ExpectedConditions.visibilityOf(playButton));
        new Actions(driver).moveToElement(playButton).build().perform();
        playButtonActive.click();
        wait.until(ExpectedConditions.visibilityOf(equalizerButton));
        //Assert.assertTrue(equalizerButton.isDisplayed());
        //wait.until(ExpectedConditions.elementToBeClickable(playButton)).click();
    }

    public void clickAllSongs(){
        WebElement allSongsMenu = wait.until(ExpectedConditions.visibilityOf(allSongs));
        allSongsMenu.click();
    }

    public void clickAlbums(){
        WebElement albumsMenu = wait.until(ExpectedConditions.visibilityOf(albums));
        albumsMenu.click();
    }

    public void clickProfileIcon() {
        wait.until(ExpectedConditions.visibilityOf(profileIcon));
        profileIcon.click();
    }

    public WebElement getUserAvatar(){
        //WebElement userAvatar = driver.findElement(By.cssSelector("img.avatar"));
        //WebElement userAvatar =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        WebElement userAvatar =  wait.until(ExpectedConditions.visibilityOf(avatar));
        //return findElement((WebElement) userAvatarIcon);
        return userAvatar;
    }

    public void enterSongsName(String song){
        WebElement searchField = wait.until(ExpectedConditions.visibilityOf(searchElement));
        //WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        searchField.sendKeys(song);
    }

    public void createPlaylist(String playlistName){
        addPlaylistButton.click();
        newPlaylistButton.click();
        inputField.clear();
        inputField.sendKeys(playlistName);
        inputField.sendKeys(Keys.ENTER);
    }

    public String verifyNotificationMessage() {
        wait.until(ExpectedConditions.visibilityOf(notificationMessage));
        return notificationMessage.getText();
    }

    /*
    WebElement notification;
    public HomePage waitForInvisibilityOfNotificationMessage() {
       wait.until(ExpectedConditions.invisibilityOf(notification));
        return this;
    }
     */





}
