import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class Homework17 extends BaseTest {

    //public String url = "https://qa.koel.app";

    @Test
    public void validemailpasswordlogin() {

        navigateToLoginPage();
        provideEmail("Demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        closeBrowser();

    }
    @Test
    public void addSongsToPlaylist() throws InterruptedException{

        String expectedSongAddedMessage ="Added 1 song into \"test.\" ";

        navigateToLoginPage();
        provideEmail("Demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("BornKing");
        clickViewAllButton();
        selectFirstSongResult();
        clickAddToButton();
        //generateRandomPlaylistName();
        choosePlaylist();

        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);



    }

    public void choosePlaylist() throws InterruptedException{
        WebElement playlist=driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
          playlist.click();
          Thread.sleep(2000);
    }


    public String getAddToPlaylistSuccessMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div[class='success show']"));
        return notification.getText();

    }





    public void clickAddToButton() throws InterruptedException{
        WebElement addToButton= driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);

    }

    public void selectFirstSongResult()throws InterruptedException {
        WebElement firstSongInSearch = driver.findElement(By.cssSelector("#songResultsWrapper tr td.title"));
        firstSongInSearch.click();
       Thread.sleep(2000);

    }

    public void clickViewAllButton()throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);
    }

    public void searchSong(String BornKing) throws InterruptedException {
        WebElement searchfield = driver.findElement(By.cssSelector("[type='search']"));
        searchfield.clear();
        searchfield.sendKeys("BornKing");
        Thread.sleep(2000);

    }

}

