package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

import static pages.HomePage.generateRandomString;

public class PlaylistTests extends BaseTest {
    String myPlaylist = "Alina's favorites";
    @Test (priority = 1)
    public void createNewPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        loginPage.login();
        homePage.createPlaylist(myPlaylist);

        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOf(homePage.newlyCreatedPlaylist));
        Assert.assertTrue(newPlaylist.isDisplayed(), "Playlist was NOT created");

        String expectedMessage = "Created playlist \"" + myPlaylist + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);
    }

    @Test (priority = 2)
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.login();
        homePage.clickAllSongs();
        allSongsPage.songToAdd.click();
        allSongsPage.addToButton.click();
        allSongsPage.addSongToPlaylist();
        allSongsPage.verifyNotificationMessage();

        //what assert is better? option 1 or 2?
        //option 1
        String expectedMessage = "Added 1 song into \"" + myPlaylist + ".\"";
        Assert.assertEquals(allSongsPage.verifyNotificationMessage(), expectedMessage);

        //option 2
        homePage.myPlaylist.click();
        Assert.assertTrue(playlistPage.addedSong.isDisplayed(), "No songs in Playlist");
    }

    @Test (priority = 3, dataProvider = "PlaylistNameData", dataProviderClass = BaseTest.class)
    public void createPlaylistWithLongShortName(String playlistName) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.createPlaylist(playlistName);

        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOf(homePage.newlyCreatedPlaylist));
        Assert.assertTrue(newPlaylist.isDisplayed(), "Playlist was NOT created");

        String expectedMessage = "Created playlist \"" + playlistName + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);
    }
}
