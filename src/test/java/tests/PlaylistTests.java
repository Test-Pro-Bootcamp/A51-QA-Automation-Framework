package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.Random;

public class PlaylistTests extends BaseTest {
    String playlistName = "Playlist";
    @Test (priority = 1)
    public void createNewPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.createPlaylist(playlistName);

        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOf(homePage.newlyCreatedPlaylist));
        Assert.assertTrue(newPlaylist.isDisplayed(), "Playlist was NOT created");

        String expectedMessage = "Created playlist \"" + playlistName + ".\"";
        Assert.assertEquals(homePage.verifyNotificationMessage(), expectedMessage);
    }

    @Test (priority = 2)
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();
        homePage.clickAllSongs();

        Random rand = new Random();
        int randomIndex = rand.nextInt(allSongsPage.songsInList.size());

        allSongsPage.songsInList.get(randomIndex).click();
        allSongsPage.addToButton.click();
        allSongsPage.addSongToPlaylist();
        allSongsPage.verifyNotificationMessage();

        String expectedMessage = "Added 1 song into \"" + playlistName + ".\"";
        Assert.assertEquals(allSongsPage.verifyNotificationMessage(), expectedMessage);
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
