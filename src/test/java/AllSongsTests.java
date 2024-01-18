import Pages.AllSongsPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTests extends BaseTest{

    @Test
    public void playFirstSong(){
        LoginPage loginPage = new LoginPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        loginPage.loginValidCredentials();;
        allSongsPage.navigateToAllSongs().checkTitleHeader().contextClickFirstSong().choosePlayOption();
        Assert.assertTrue(allSongsPage.checkSongIsPlaying());
    }


}
