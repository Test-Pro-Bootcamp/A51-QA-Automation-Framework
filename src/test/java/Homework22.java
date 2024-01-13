import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Love1";
        String updatedPlaylistMsg = "Updated playlist\"Love1.\"";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getrenamePlaylistSuccessMsg(), homePage.updatedPlayListMsg);
    }

    }

