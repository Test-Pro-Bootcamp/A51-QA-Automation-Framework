package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class InfoPanelTests extends BaseTest {
    @Test
    public void verifyLyricsTabInfo()  {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickPlayButton();
        infoPanelPage.verifyLyricsTab();
        Assert.assertTrue(infoPanelPage.lyricsTabElement.isDisplayed());
    }

    @Test
    public void verifyArtistTabInfo()  {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickPlayButton();
        infoPanelPage.artistTabElement.click();
        Assert.assertEquals(homePage.artistPlaying.getText(), infoPanelPage.artistNameInfoPanel.getText());
    }

    @Test
    public void verifyAlbumTabInfo()  {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickPlayButton();
        infoPanelPage.albumTabElement.click();

        String alb = homePage.albumPlaying.getText();
        String albInfo = infoPanelPage.albumTabElement.getText();
        Assert.assertEquals(albInfo.contains(alb), alb.contains(albInfo));
    }

    @Test
    public void verifyHideInfoTab()  {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickPlayButton();
        homePage.clickInfoFooterButton();

        boolean isElementNotVisible = wait.until(ExpectedConditions.invisibilityOf(infoPanelPage.lyricsTabElement));
        Assert.assertTrue(isElementNotVisible);
    }

    @Test
    public void verifyOpenInfoTab()  {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickPlayButton();
        homePage.clickInfoFooterButton();
        homePage.clickInfoFooterButton();

        Assert.assertTrue(infoPanelPage.lyricsTabElement.isDisplayed());
    }

    @Test //shuffle button doesn't do anything
    public void verifyShuffleButtonOnArtistInfoTab() {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        loginPage.login();
        String songName = "Unknown"; //for artist section
        //String songName = "lament"; //for songs section
        homePage.enterSongsName(songName);
        searchPage.playButtonArtistSection.click();
        //searchPage.playButtonSongsSection.click();

        List<WebElement> originalSongsList = infoPanelPage.getSongs();
        infoPanelPage.verifyLyricsTab();
        infoPanelPage.clickArtistInfoTab();
        infoPanelPage.clickShuffleArtistButton();
        List<WebElement> shuffledSongsList = infoPanelPage.getSongs();

        Assert.assertEquals(originalSongsList, shuffledSongsList);
    }

    @Test
    public void verifyShuffleButtonOnAlbumInfoTab() {
        LoginPage loginPage = new LoginPage(driver);
        InfoPanelPage infoPanelPage = new InfoPanelPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        loginPage.login();
        String songName = "Unknown";
        homePage.enterSongsName(songName);
        searchPage.playButtonArtistSection.click();

        List<WebElement> originalSongsList = infoPanelPage.getSongs();
        System.out.println("First song in original list: " + originalSongsList.get(0).getText());
        infoPanelPage.clickAlbumInfoTab();
        infoPanelPage.clickShuffleAlbumButton();

        List<WebElement> shuffledSongsList = infoPanelPage.getSongsShuffled();

        //Assert.assertEquals(originalSongsList, shuffledSongsList);
        System.out.println("First song in original list: " + originalSongsList.get(0).getText());
        System.out.println("First song in shuffled list: " + shuffledSongsList.get(0).getText());
        Assert.assertNotEquals(originalSongsList.get(0).getText(), shuffledSongsList.get(0).getText());
    }

}
