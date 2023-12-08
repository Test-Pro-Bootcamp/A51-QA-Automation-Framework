import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTest extends BaseTest{


    @Test
    public void checkFirstSongIsPlaying(){

        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        homePage.clickAllSongs();

        allSongsPage.contextClickFirstSong();
        allSongsPage.clickPlaySoundTrack();

        Assert.assertTrue(allSongsPage.soundBarIcon());
    }
}
