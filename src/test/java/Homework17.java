import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.ref.WeakReference;
import java.util.Collection;

public class Homework17 extends BaseTest {


    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotificationText = "Added 1 song into \"A51 playlist.\"";

        navigateToPage();
        provideEmail("jguy1@stny.rr.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("Reactor");
        clickViewAllButton();
        selectFirstSongResult();
        clickAddSongButton();
        selectPlaylist();

        Assert.assertEquals(notificationText(), newSongAddedNotificationText);

    }

    public void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm > input[type='search']"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(2000);
    }

    public void clickViewAllButton() throws InterruptedException {
        WebElement seeAllSearchResults = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section > h1 > button"));
        seeAllSearchResults.click();
        Thread.sleep(2000);
    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSongResult.click();
        Thread.sleep(2000);
    }

    public void clickAddSongButton() throws InterruptedException {
        WebElement addSongButton = driver.findElement(By.cssSelector("Button[class='btn-add-to']"));
        addSongButton.click();
        Thread.sleep(2000);
    }

    public void selectPlaylist() throws InterruptedException {
        WebElement selectPlaylist = driver.findElement(By.xpath("//section[@id ='songResultsWrapper']//li[contains(text(),'A51 playlist')]"));
        selectPlaylist.click();
        Thread.sleep(2000);
    }

    public String notificationText() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}
