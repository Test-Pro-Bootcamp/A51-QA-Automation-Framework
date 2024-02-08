import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{
    @Test
    public void deletePlaylistTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideLoginSucceed();
        homePage.chooseFirstPlaylist().deletePlaylist();
        Assert.assertTrue(homePage.notificationText());
    }
}
