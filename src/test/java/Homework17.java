import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException{

        String expectedAddedSongToPlaylistSuccessMsg = "Added 1 song into \"AutoLesson 17.\"";
        navigateToLoginPage();
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        //Wait for 2 seconds
        Thread.sleep(2000);
        //Search for song
        searchSong("Tunnel of Lights");
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedAddedSongToPlaylistSuccessMsg);
    }

    public void searchSong(String name) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
        Thread.sleep(2000);
    }

    public void selectFirstSong() throws InterruptedException{
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper tr.song-item"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickAddToBtn() throws InterruptedException{
        WebElement addToButton = driver.findElement(By.cssSelector("button[data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'AutoLesson 17')]"));
        playlist.click();
        Thread.sleep(5000);
    }

    public String getAddToPlaylistSuccessMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}


