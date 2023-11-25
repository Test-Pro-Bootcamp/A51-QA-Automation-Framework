package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AllSongsPage extends BasePage{
    @FindBy(xpath = "//h1[text()[normalize-space()='All Songs']]")
    private WebElement allSongsPageTitleLocator;
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    private WebElement firstSongElementLocator;
    @FindBy(css = "li.playback")
    private WebElement choosePlayAllLocator;
//    @FindBy(css = "[data-testid='sound-bar-play']")
//    private WebElement soundBarVisualizer;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a")
    private By allSongsLocator;

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean checkSongPlaying() {
        return isSongPlaying();
    }
    public AllSongsPage navigateToAllSongs() {
        click(allSongsLocator);
        return this;
    }
    public AllSongsPage checkHeaderTitle() {
        findElement(allSongsPageTitleLocator);
        Assert.assertTrue(allSongsPageTitleLocator.isDisplayed());
        return this;
    }

    public AllSongsPage contextClickFirstSong() {
        contextClick(firstSongElementLocator);
        return this;
    }

    public void choosePlayOption() {
       choosePlayAllLocator.click();
    }

}
