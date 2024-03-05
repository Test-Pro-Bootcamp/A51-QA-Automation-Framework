package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class InfoPanelPage extends BasePage {
    public InfoPanelPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(id = "extraTabLyrics")
    public WebElement lyricsTabElement;

    @FindBy(id = "extraTabArtist")
    public WebElement artistTabElement;

    @FindBy(xpath = "//*[@id=\"extraPanelArtist\"]/article/h1")
    public WebElement artistNameInfoPanel;

    @FindBy(id = "extraTabAlbum")
    public WebElement albumTabElement;

    @FindBy(css = "#extraPanelArtist > article > h1 > button > i")
    public WebElement shuffleArtistButton;

    @FindBy(css = "#extraPanelAlbum > article > h1 > button > i")
    public WebElement shuffleAlbumButton;

    @FindBy(xpath = "//*[@id=\"queueWrapper\"]/div/div/div[1]/table/tr")
    public List<WebElement> songElements;
    //*[@id="queueWrapper"]/div/div/div[1]/table/tr[1]

    @FindBy(xpath = "//*[@id=\"queueWrapper\"]/div/div/div[1]/table/tr[1]")
    public WebElement firstSong;

    @FindBy(xpath = "//*[@id=\"queueWrapper\"]/div/div/div[1]/table/tr[1]")
    public WebElement firstSongShuffled;

    public void verifyLyricsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(lyricsTabElement));
    }

    public void clickArtistInfoTab() {
        wait.until(ExpectedConditions.elementToBeClickable(artistTabElement));
        artistTabElement.click();
    }

    public void clickAlbumInfoTab() {
        wait.until(ExpectedConditions.elementToBeClickable(albumTabElement));
        albumTabElement.click();
    }

    public void clickShuffleArtistButton() {
        wait.until(ExpectedConditions.elementToBeClickable(shuffleArtistButton));
        shuffleArtistButton.click();
    }

    public void clickShuffleAlbumButton() {
        wait.until(ExpectedConditions.elementToBeClickable(shuffleAlbumButton));
        shuffleAlbumButton.click();
        wait.until(ExpectedConditions.visibilityOf(firstSong));
    }

    private List<WebElement> songs = null; // Cached list of songs

    public List<WebElement> getSongs(){
        if (songs == null) {
            wait.until(ExpectedConditions.visibilityOf(firstSong));
            songs = new ArrayList<>();
            for (WebElement songElement: songElements){
                songs.add(songElement);
                //System.out.println(songElement.getText());
            }
        }
        return songs;
    }

    public List<WebElement> getSongsShuffled(){
        if (songs == null) {
            wait.until(ExpectedConditions.visibilityOf(firstSongShuffled));
            songs = new ArrayList<>();
            for (WebElement songElement: songElements){
                songs.add(songElement);
                //System.out.println(songElement.getText());
            }
        }
        return songs;
    }




}



