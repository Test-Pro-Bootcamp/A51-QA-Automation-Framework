package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SmartPlaylistPage;

public class SmartPlaylistTests extends BaseTest{

    @Test
    public void createNewSmartPlaylistWithOneRule(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(driver);

        loginPage.login();
        homePage.addPlaylistButton.click();
        homePage.newSmartPlaylistButton.click();

        smartPlaylistPage.provideNameForSmartPlaylist();
        smartPlaylistPage.selectFirstDropdown();
        smartPlaylistPage.selectSecondDropdown();
        smartPlaylistPage.provideRuleInputField();
        smartPlaylistPage.clickSaveButton();

        //smartPlaylistPage.verifyNotificationMessage();
        //String expectedMessage = "Created playlist \"" + smartPlaylistPage.nameInputField + ".\"";
        //Assert.assertEquals(smartPlaylistPage.verifyNotificationMessage(), expectedMessage);
        Assert.assertEquals(smartPlaylistPage.createdSmartPlaylist.getText(), smartPlaylistPage.smartPlaylistName);
    }
}
