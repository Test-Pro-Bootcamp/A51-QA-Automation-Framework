package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']")
    private WebElement searchResult;

    @FindBy(xpath = "//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']")
    private WebElement songsSection;

    @FindBy(xpath = "//*[@id='searchExcerptsWrapper']/div/div/section[3]")
    private WebElement albumSection;

    @FindBy(xpath = "//*[@id='searchExcerptsWrapper']/div/div/section[2]")
    private WebElement artistSection;

    public String verifySongsResult(){
        WebElement songInSearchResults = wait.until(ExpectedConditions.visibilityOf(searchResult));
        return  songInSearchResults.getText();
    }

    public String verifyResultsInSongsSection(){
        WebElement resultsSongs = wait.until(ExpectedConditions.visibilityOf(songsSection));
        return resultsSongs.getText();
    }

    public String verifyResultsInArtistSection(){
        WebElement resultsSongs = wait.until(ExpectedConditions.visibilityOf(artistSection));
        return resultsSongs.getText();
    }

    public String verifyResultsInAlbumSection(){
        WebElement resultsSongs = wait.until(ExpectedConditions.visibilityOf(albumSection));
        return resultsSongs.getText();
    }
}
