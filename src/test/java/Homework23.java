import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Homework23 extends BaseTest {

    //public Homework23(WebDriver givenDriver) {
        //super(givenDriver);
   // }

    @Test

    public void renamePlaylist(){

        String updatedPlaylistName= "Updated playlist \"melodious album.\"";

        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        homePage.contextClickPlaylist();
        homePage.clickEdit();
        homePage.enterNewPlaylistName("melodious album");

        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),updatedPlaylistName);

    }
}
