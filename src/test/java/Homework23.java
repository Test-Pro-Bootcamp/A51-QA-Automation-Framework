import PageObjectModel.LoginPage;
import PageObjectModel.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Homework23 extends BaseTest {

   // public WeDriver clickDeletePlaylistBtn;

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
