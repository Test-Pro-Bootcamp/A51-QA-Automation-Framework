import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.AllSongsPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class ActionsTests extends BaseTest {

//  Test #1 - POM Recap Example
    @Test
    public void playSong()  {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();

        homePage.chooseAllSongsList();

        allSongs.contextClickFirstSong()
                .choosePlayOption();

        Assert.assertTrue(allSongs.isSongPlaying());
    }
}
