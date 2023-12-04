/**
import Pages.HomePage;
import Pages.LoginPage;
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
        //call login methods from LoginPage
        loginPage.provideEmail("adam.johnson@testpro.io").providePassword("1Te$t$tudent").clickSubmitBtn();

        //homePage.openPlaylist(); change these methods and check HomePage page object
        //WHEN
        //Assert.assertEquals(homePage.getDeletedPlaylistMsg(), expectedPLayListDeletedMessage);

    }


}

**/