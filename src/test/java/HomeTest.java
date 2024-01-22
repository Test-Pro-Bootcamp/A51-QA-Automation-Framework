import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{

    String newPlaylistName = "Sample Edited Playlist";
    @Test
    public void playSongWithContextClick() throws InterruptedException {
        provideEmail("zhanna.ivanova@testpro.io");
        providePassword("12345678");
        clickSubmit();
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();
        Assert.assertTrue(isSongPlaying());
    }

    @Test
    public void hoverOverPlayButton() throws InterruptedException {
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Assert.assertTrue(hoverPlay().isDisplayed());
    }
    @Test
    public void countSongsInPlaylist() throws InterruptedException {
        //Login
        provideEmail("zhanna.ivanova@testpro.io");
        providePassword("12345678");
        clickSubmit();
        Thread.sleep(2000);
        choosePlaylistByName("DEMO PLAYLIST");
        Thread.sleep(2000);
        displayAllSongs();
        Thread.sleep(2000);
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));

    }

    @Test
    public void renamePlayList() throws InterruptedException {

        String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
        provideEmail("zhanna.ivanova@testpro.io");
        providePassword("12345678");
        clickSubmit();
        Thread.sleep(2000);
        doubleClickPlaylist();
        Thread.sleep(2000);
        enterNewPlaylistName();
        Thread.sleep(2000);
        Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);
    }

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return  notification.getText();
    }


    public void choosePlaylistByName(String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();
    }

    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public void displayAllSongs(){
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Soungs found: "+countSongs());
        for (WebElement e: songList){
            System.out.println(e.getText());
        }
    }


    public WebElement hoverPlay() throws InterruptedException {
        //WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return  wait.until(ExpectedConditions.visibilityOf(play));
    }


    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong(){
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }

    public void choosePlayOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid= 'sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }


}