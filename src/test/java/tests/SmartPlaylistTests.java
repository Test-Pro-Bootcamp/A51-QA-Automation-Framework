package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SmartPlaylistPage;

public class SmartPlaylistTests extends BaseTest{
    String smartPlaylistName = "SmartPlaylist";

    String ruleInput = "b";

    String ruleSecondInput = "A";

    String groupInput = "C";
    @Test
    public void createNewSmartPlaylistWithOneRule(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(driver);

        loginPage.login();
        homePage.addPlaylistButton.click();
        homePage.newSmartPlaylistButton.click();

        smartPlaylistPage.provideNameForSmartPlaylist(smartPlaylistName);
        smartPlaylistPage.selectFirstDropdown();
        smartPlaylistPage.selectSecondDropdown();
        smartPlaylistPage.provideRuleInputField(ruleInput);
        smartPlaylistPage.clickSaveButton();

        wait.until(ExpectedConditions.visibilityOf(smartPlaylistPage.createdSmartPlaylist));

        //smartPlaylistPage.verifyNotificationMessage();
        //String expectedMessage = "Created playlist \"" + smartPlaylistPage.nameInputField + ".\"";
        //Assert.assertEquals(smartPlaylistPage.verifyNotificationMessage(), expectedMessage);
        Assert.assertEquals(smartPlaylistPage.createdSmartPlaylist.getText(), smartPlaylistName);
    }

    @Test
    public void createNewSmartPlaylistWithMultipleRule(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(driver);

        loginPage.login();
        homePage.addPlaylistButton.click();
        homePage.newSmartPlaylistButton.click();

        smartPlaylistPage.provideNameForSmartPlaylist(smartPlaylistName);

        smartPlaylistPage.provideFirstRule(ruleInput);

        smartPlaylistPage.clickAddRuleButton();
        smartPlaylistPage.provideSecondRule(ruleSecondInput);

        smartPlaylistPage.clickSaveButton();

        wait.until(ExpectedConditions.visibilityOf(smartPlaylistPage.createdSmartPlaylist));
        Assert.assertEquals(smartPlaylistPage.createdSmartPlaylist.getText(), smartPlaylistName);
    }

    @Test
    public void createNewSmartPlaylistWithGroup(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(driver);

        loginPage.login();
        homePage.addPlaylistButton.click();
        homePage.newSmartPlaylistButton.click();

        smartPlaylistPage.provideNameForSmartPlaylist(smartPlaylistName);
        smartPlaylistPage.provideFirstRule(ruleInput);
        smartPlaylistPage.addGroupButton.click();
        smartPlaylistPage.provideGroup(groupInput);

        smartPlaylistPage.clickSaveButton();

        wait.until(ExpectedConditions.visibilityOf(smartPlaylistPage.createdSmartPlaylist));
        Assert.assertEquals(smartPlaylistPage.createdSmartPlaylist.getText(), smartPlaylistName);
    }

    @Test
    public void createEmptySmartPlaylistWithOneRule(){
        String emptySmartPlaylistName = "Empty Smart Playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartPlaylistPage smartPlaylistPage = new SmartPlaylistPage(driver);

        loginPage.login();
        homePage.addPlaylistButton.click();
        homePage.newSmartPlaylistButton.click();

        smartPlaylistPage.provideNameForSmartPlaylist(emptySmartPlaylistName);
        smartPlaylistPage.selectFirstDropdown();
        smartPlaylistPage.selectSecondDropdown();
        smartPlaylistPage.provideRuleInputField("qwerty");
        smartPlaylistPage.clickSaveButton();

        wait.until(ExpectedConditions.visibilityOf(smartPlaylistPage.createdSmartPlaylist));

        String expectedMessage = "No songs match the playlist's criteria.";
        Assert.assertEquals(smartPlaylistPage.getTextMessage(), expectedMessage);
    }
}
