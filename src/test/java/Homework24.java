import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework24 extends BaseTest {



    //Prerequisite - empty playlist to delete

    @Test
    public void deletePlaylist() {
        //GIVEN
        String expectedPLayListDeletedMessage = "Deleted playlist \"Golden Girls.\"";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //THEN
        loginPage.provideEmailToLogin("adam.johnson@testpro.io").providePasswordToLogin("1Te$t$tudent").clickSubmitBtnToLogin();
        homePage.openPlaylist();
        homePage.clickDeletePlaylistBtn();

        //WHEN
        Assert.assertEquals(homePage.getDeletedPlaylistMsg(), expectedPLayListDeletedMessage);
    }


}
