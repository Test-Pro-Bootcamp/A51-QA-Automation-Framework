import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    private String updatedPlayListMsg;
    

    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Love4";
        String updatedPlaylistMsg = "Updated playlist\"Love4.\"";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getrenamePlaylistSuccessMsg(), updatedPlayListMsg);
    }

    }

