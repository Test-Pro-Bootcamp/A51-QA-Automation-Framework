import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    //Prerequisite = User has at created at least one playlist
   String newPlaylistName = "Abracadabra";
    @Test
    public void renamePlaylist(){
        //Login
        provideEmail("adam.johnson@testpro.io");
        providePassword("1Te$t$tudent");
        clickSubmit();
        //Right/Context click
        contextClickPlaylist();
        //Enter new Playlist name
        enterNewPlaylistName();
        //Assertion
        Assert.assertTrue(doesPlaylistExist());
    }
    public void contextClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        actions.contextClick(playlistElement).perform();
    }
    public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[(text()='" + newPlaylistName + "']")));
        return playlistElement.isDisplayed();
    }
    }

