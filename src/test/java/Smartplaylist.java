import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import pages.SmartplaylistPage;


public class Smartplaylist extends BaseTest {


    @Test

    public void createNewSmartPlaylistWithOneRule() {

        String createdSmartPlaylistName = "Created playlist \"melodious album.\"";
        String getThirdFieldInput= "s";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartplaylistPage smartplaylistPage= new SmartplaylistPage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        homePage.clickPlaylist();
        homePage.clickSmartPlaylist();


        smartplaylistPage.enterSmartPlaylistName("melodious album");
        smartplaylistPage.selectFirstDropdown();
        smartplaylistPage.selectSecondDropdown();
        smartplaylistPage.provideThirdFieldInput("s");
        smartplaylistPage.hitSave();

        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), createdSmartPlaylistName);


    }

    @Test
    public void createNewSmartPlaylistWithMultipleRule(){
        String createdSmartPlaylistName = "Created playlist \"melodious album1.\"";
        //String getThirdFieldInput= "s";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartplaylistPage smartplaylistPage= new SmartplaylistPage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        homePage.clickPlaylist();
        homePage.clickSmartPlaylist();


        smartplaylistPage.enterSmartPlaylistName("melodious album1");
        smartplaylistPage.selectFirstDropdown();
        smartplaylistPage.selectSecondDropdown();
        smartplaylistPage.provideThirdFieldInput("s");
        smartplaylistPage.clickAddRule();
        smartplaylistPage.selectSecondRulFirstDropdown();
        smartplaylistPage.selectSecondRulSecondDropdown();
        smartplaylistPage.provideSecondRuleThirdFieldInput("Unknown Artist");

        smartplaylistPage.hitSave();

        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), createdSmartPlaylistName);

    }

    @Test
    public void createNewSmartPlaylistWithMultipleRuleAndGroup(){
        String createdSmartPlaylistName = "Created playlist \"melodious album2.\"";
        //String getThirdFieldInput= "s";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartplaylistPage smartplaylistPage= new SmartplaylistPage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        homePage.clickPlaylist();
        homePage.clickSmartPlaylist();


        smartplaylistPage.enterSmartPlaylistName("melodious album2");
        smartplaylistPage.selectFirstDropdown();
        smartplaylistPage.selectSecondDropdown();
        smartplaylistPage.provideThirdFieldInput("s");
        smartplaylistPage.clickAddRule();
        smartplaylistPage.selectSecondRulFirstDropdown();
        smartplaylistPage.selectSecondRulSecondDropdown();
        smartplaylistPage.provideSecondRuleThirdFieldInput("Unknown Artist");
        smartplaylistPage.clickAddGroup();
        smartplaylistPage.selectGroupFirstDropdown();
        smartplaylistPage.selectGroupSecondDropdown();
        smartplaylistPage.selectGroupThirdFieldInput("m");

        smartplaylistPage.hitSave();

        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), createdSmartPlaylistName);

    }

    @Test

    public void createEmptySmartPlaylistWithOneRule() {

        String createdSmartPlaylistName = "Created playlist \"melodious album3.\"";
        String expectedMessage="No songs match the playlist's criteria." ;


        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SmartplaylistPage smartplaylistPage= new SmartplaylistPage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        homePage.clickPlaylist();
        homePage.clickSmartPlaylist();


        smartplaylistPage.enterSmartPlaylistName("melodious album3");
        smartplaylistPage.selectFirstDropdown();
        smartplaylistPage.selectSecondDropdown();
        smartplaylistPage.provideThirdFieldInput("y");

        smartplaylistPage.hitSave();

        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), createdSmartPlaylistName);
        Assert.assertEquals(smartplaylistPage.getTextMessage(),expectedMessage);


    }
}