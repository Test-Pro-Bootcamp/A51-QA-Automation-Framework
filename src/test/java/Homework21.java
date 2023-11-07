import jdk.jshell.spi.ExecutionControlProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {

        // GIVEN
        String user = "iryna.berezkina@testpro.io";
        String password = "pnPGl1hk";
        String playlistName = "My Playlist";
        String newPlaylistName = "Renamed Playlist";

        //WHEN
        provideEmail(user);
        providePassword(password);
        clickSubmit();
        createPlaylist(playlistName);
        renamePlaylist(playlistName, newPlaylistName);

        //THEN
        Boolean isRenamed = false;
        WebElement playlistsSection = driver.findElement(By.id("playlists"));
        List<WebElement> playlists = playlistsSection.findElements(By.cssSelector("*[class='playlist playlist']"));
        for (WebElement playlist : playlists) {
            if (playlist.getText().equals(newPlaylistName)) {
                isRenamed = true;
            }
        }
        Assert.assertTrue(isRenamed);
    }

    private void createPlaylist(String name) {
        WebElement addPlaylistButton = driver.findElement(By.xpath("//*[@id='playlists']/h1/i"));
        addPlaylistButton.click();

        WebElement newPlaylistButton = driver.findElement(By.xpath("//*[@id='playlists']/nav/ul/li[1]"));
        newPlaylistButton.click();

        WebElement playlistNameInput = driver.findElement(By.xpath("//*[@id='playlists']/form/input"));
        playlistNameInput.sendKeys(name);
        playlistNameInput.sendKeys(Keys.RETURN);
    }

    private void renamePlaylist(String oldName, String newName) {
        WebElement playlistsSection = driver.findElement(By.id("playlists"));
        List<WebElement> playlists = playlistsSection.findElements(By.cssSelector("*[class='playlist playlist']"));
        for (WebElement playlist: playlists) {
            if (playlist.getText().equals(oldName)) {
                Actions action = new Actions(driver);
                action.contextClick(playlist).perform();
                WebElement editButton = driver.findElement(By.cssSelector("[data-testid^='playlist-context-menu-edit']"));
                editButton.click();
                WebElement input = driver.findElement(By.cssSelector("[data-testid='inline-playlist-name-input']"));
                input.sendKeys(Keys.CONTROL + "a");
                input.sendKeys(Keys.DELETE);
                input.sendKeys(newName);
                input.sendKeys(Keys.RETURN);
                break;
            }
        }
    }
}
