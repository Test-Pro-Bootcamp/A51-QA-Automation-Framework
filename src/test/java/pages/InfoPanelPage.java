package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class InfoPanelPage extends BasePage {
    public InfoPanelPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (id = "extraTabLyrics")
    public WebElement lyricsTabElement;

    @FindBy (id = "extraTabArtist")
    public WebElement artistTabElement;

    @FindBy (xpath = "//*[@id=\"extraPanelArtist\"]/article/h1")
    public WebElement artistNameInfoPanel;

    @FindBy (id = "extraTabAlbum")
    public WebElement albumTabElement;

    public void verifyLyricsTab(){
        wait.until(ExpectedConditions.elementToBeClickable(lyricsTabElement));
        //lyricsTabElement.click();
    }


}
