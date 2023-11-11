import PageObjectModel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{

    //Prerequisite - empty playlist to delete

    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedPLayListDeletedMessage = "Deleted playlist \"Golden Girls.\"";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmailToLogin("adam.johnson@testpro.io").providePasswordToLogin("1Te$t$tudent").clickSubmitBtnToLogin();
        openPlaylist();
        Thread.sleep(5000);
        clickDeletePlaylistBtn();
        Thread.sleep(5000);
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPLayListDeletedMessage);
    }




}
