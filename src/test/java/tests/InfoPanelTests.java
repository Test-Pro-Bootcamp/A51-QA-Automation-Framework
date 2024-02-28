package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

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

}
