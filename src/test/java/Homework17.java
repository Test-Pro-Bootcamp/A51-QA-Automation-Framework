import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessege = "Added 1 song into \"Test Pro Playlist.\" ";
        navigateToPage();
        provideEmail("zhanna.ivanova@testpro.io");
        providePassword("12345678");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("rainday");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Thread.sleep(2000);
        Assert.assertEquals(getAddToPlayListSuccessMsg(), expectedSongAddedMessege);
    }

    public void searchSong(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }
    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickAddToBtn () throws InterruptedException {
        Thread.sleep(2000);
            WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
            addToButton.click();
            Thread.sleep(2000);
        }
        public void choosePlaylist() throws InterruptedException {
            WebElement playlist  = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Love')]"));
            playlist.click();
            Thread.sleep(2000);
        }
        public String getAddToPlayListSuccessMsg() throws InterruptedException {
        Thread.sleep(2000);
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
        }
}

