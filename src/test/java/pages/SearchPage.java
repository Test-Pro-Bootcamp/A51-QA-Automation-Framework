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


    //WebElement resultsSongs = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
    //String songsName = resultsSongs.getText();

    /*
    @FindBy(xpath = "//input[@name='q']")
    private WebElement inputField;

    @FindBy(xpath = "//section[@class='songs']//span[@class='details']")
    private WebElement songDetailsContainer;

    @FindBy(css = ".results .artists .name")
    private WebElement nameArtist;

    @FindBy(css = ".results .albums .name")
    private WebElement nameAlbum;


    public void enterSongName(String songName) {
        inputField.clear();
        inputField.click();
        findElement(inputField).sendKeys(songName);
    }

    public boolean verifySongFound(String songName) {
        findElement(songDetailsContainer);
        return songDetailsContainer.getText().contains(songName);

    }

    public String getNameArtist() {
        findElement(nameArtist);
        return nameArtist.getText();
    }

    public boolean getNameAlbum(String songName) {
        findElement(nameAlbum);
        return nameAlbum.getText().contains(songName);
    }
*/

}
