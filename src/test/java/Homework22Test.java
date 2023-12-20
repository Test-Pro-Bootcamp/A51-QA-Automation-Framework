import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22Test extends BaseTest {




    @Test
    public void renamePlaylist() {
        //Pre-Conditions-user must have a playlist created
        String newPlaylistName = "Test Play 2";
        String renameSuccessMsg = "Updated playlist \"Test Play 2.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        loginPage.login();
        homePage.clickPlaylist();
        homePage.edit();
        homePage.renamePlaylist(newPlaylistName);
        Assert.assertEquals(homePage.getRenameSuccessMsg(), renameSuccessMsg);

    }
}

