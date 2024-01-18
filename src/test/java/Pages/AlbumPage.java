package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlbumPage extends BasePage{
    //locators
    //Albums menu choice on homepage
    @FindBy(xpath = "//*[@id=\"sidebar\"]/section[1]/ul/li[4]/a")
    private WebElement albumsPageLocator;
    //play all album songs element
   @FindBy(xpath = "//li[text()='Play All']")
   private WebElement playAll;
   //shuffle current album songs element
    @FindBy(css = "li[data-test'shuffle']")
    private WebElement shuffleSongs;
    //locate first album
    @FindBy(xpath = "//*[id=\"albumsWrapper\"]/div/article[1]/span/span/a")
    private WebElement firstAlbumLocator;
    //locate albums title page
    @FindBy(xpath = "//h1[text()[normalize-space()='Albums']]")
    private WebElement albumsPageTitleLocator;
    public AlbumPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public AlbumPage navigateToAlbums(){
        albumsPageLocator.click();
        return this;
    }
    public boolean checkTitleHeader(){
        return albumsPageTitleLocator.isDisplayed();
    }
    public void selectPlayAll(){
        findElement(playAll);
        playAll.click();
    }
    public AlbumPage rightClickAlbum(){
        contextClick(firstAlbumLocator);
        return this;
    }
    public boolean checkAlbumSongIsPlaying(){
        return isSongPlaying();
    }
    
}