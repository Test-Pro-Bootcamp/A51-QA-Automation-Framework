import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{

    @Test
    public void playSongsWithContextClick(){
        //Login
provideEmail("daria.chebotnyagina@testpro.io");
providePassword("Asdfasdf1");
clickSubmit();
        //Choose all songs list
chooseAllSongsList();
        // Right/Context Click
contextClickFirstSong();
        // Choose Play
choosePlayOption();
        //Assertion
        WebElement play = driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        Assert.assertTrue(play.isDisplayed());
    }

    @Test
    public void hoverOverPlayButton() throws InterruptedException{
        //Login
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();
        //Hover
Thread.sleep(2000);
        //Assertion
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    @Test
    public void countSongsInPlaylist() throws InterruptedException{
        //Login
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();
        Thread.sleep(2000);
        //choose playlist by name
        choosePlaylistByName("dasha");
        Thread.sleep(2000);
        //display all songs
        displayAllSongs();
        Thread.sleep(2000);
        //Assertion
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    public void choosePlaylistByName(String playListName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playListName+"')]"))).click();
    }

    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public void displayAllSongs(){
        List<WebElement> songsList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: "+countSongs());
        for(WebElement e: songsList){
            System.out.println(e.getText());
        }

    }

    public WebElement hoverPlay(){
        WebElement play = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        action.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong(){
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        action.contextClick(firstSongElement).perform();
    }

    public void choosePlayOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='playback']"))).click();
    }



}
