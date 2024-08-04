import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeworkAddSongs extends BaseTest{
    @Test
    public void AddSongsToPlaylists() throws InterruptedException {
        String expectedSongAddedMsg="Added 1 Song into\"My Songs playlist.\" " ;
        navigateToPage();
        provideEmail("Shuban.laddu@gmail.com");
        providePassword("Pavani@10");
        clickSubmit();
        Thread.sleep(2000);
        searchSongs("Reactor");
        clickViewAllBtn();
        ClickFirstSongResult();
        ClickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccussMsg(),expectedSongAddedMsg);
    }

    private String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    private void choosePlaylist() throws InterruptedException {
        WebElement ChoosePlayList=driver.findElement(By.cssSelector("section[id='playlist']li a.active"));
        ChoosePlayList.click();
        Thread.sleep(2000);
    }

    public void ClickAddToBtn() throws InterruptedException{
       WebElement addToBtn = driver.findElement(By.xpath("section[@id='songResultWrapper']//button[@data-test='add-to-btn']"));
       addToBtn.click();
       Thread.sleep(2000);
    }

    public void ClickFirstSongResult() throws InterruptedException{
        WebElement firstSongResult =driver.findElement(By.xpath("//section[@id='songResultWrapper']//tr[@class='song.item'][1]"));
        firstSongResult.click();
        Thread.sleep(2000);
    }

    public void searchSongs(String reactor) throws InterruptedException{
        WebElement searchField= driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }
    public void clickViewAllBtn() throws InterruptedException{
      WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
      viewAll.click();
      Thread.sleep(2000);
    }
}

