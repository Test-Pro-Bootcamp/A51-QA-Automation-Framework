import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Homework23 extends BaseTest {

    @Test
    public void renamePlaylist(){

        String updatedPlaylistName= "Updated playlist \"Sanjeelas Playlist.\"";

        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("sanjeela.chitrakar@testpro.io");
        loginPage.providePassword("te$t$tudent1");
        loginPage.clickSubmit();

        homePage.contextClickPlaylist();
        homePage.clickEdit();
        homePage.enterNewPlaylistName("Sanjeelas Playlist");

        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),updatedPlaylistName);

    }
}