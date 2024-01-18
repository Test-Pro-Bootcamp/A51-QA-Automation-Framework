package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AllSongsPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a")
    private WebElement allSongsPageLocator;
    @FindBy(xpath = "//*[@id=\"songsWrapper\"]/header/div[2]/h1")
    private WebElement allSongsPageTitleLocator;
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    private WebElement firstSongElementLocator;
    @FindBy(css = "#mainFooter > div.side.player-controls > span > span.play")
    private WebElement playOrResumeButtonLocator;
    @FindBy(css = "li.playback")
    private WebElement choosePlayAllLocator;


    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public AllSongsPage navigateToAllSongs(){
        allSongsPageLocator.click();
        return this;
    }
    public AllSongsPage checkTitleHeader(){
        findElement(allSongsPageTitleLocator);
        Assert.assertTrue(allSongsPageTitleLocator.isDisplayed());
        return this;
    }
    public AllSongsPage contextClickFirstSong(){
        contextClick(firstSongElementLocator);
        return this;
    }
    public AllSongsPage clickPlayOrResume(){
        playOrResumeButtonLocator.click();
        return this;
    }

    public void choosePlayOption(){
        choosePlayAllLocator.click();
    }
    public boolean checkSongIsPlaying(){
        return isSongPlaying();
    }

}
