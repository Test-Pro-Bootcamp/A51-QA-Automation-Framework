import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{

    @Test
    public void renamePlayList(){
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        String newPlayListName = "New Playlist";
        String updateMsg = "Updated playlist \"New Playlist.\"";

        loginpage.login();
        homepage.doubleClickPlayList();
        homepage.enterNewPlayListName(newPlayListName);

        Assert.assertEquals(homepage.getRenamePlayListSuccessMsg(), updateMsg);
    }

    @Test
    public void playSongTest() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginpage.login();
        homepage.clickNextSong();
        homepage.clickPlay();

        Assert.assertTrue(homepage.getResult().isDisplayed());
    }
}


