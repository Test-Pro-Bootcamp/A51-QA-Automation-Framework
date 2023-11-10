package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {

    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    WebElement firstSong;
    @FindBy(css = "li.playback")
    WebElement playOption;

    @FindBy(css = "[data-testid='sound-bar-play']")
    WebElement soundBarVisualizer;
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public AllSongsPage contextClickFirstSong()   {
        super.contextClick(firstSong);
        return this;
    }
    public AllSongsPage choosePlayOption() {
        super.click(playOption);
        return this;
    }
    public boolean isSongPlaying() {
        return findElement(soundBarVisualizer).isDisplayed();
    }
}
