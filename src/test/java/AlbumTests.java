import Pages.AlbumPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlbumTests extends BaseTest {

    @Test
    public void playFirstAlbumSongs() {
        LoginPage loginPage = new LoginPage(getDriver());
        AlbumPage albumPage = new AlbumPage(getDriver());
        loginPage.loginValidCredentials();
        albumPage.navigateToAlbums().rightClickAlbum().selectPlayAll();
        Assert.assertTrue(albumPage.checkAlbumSongIsPlaying());
    }

}
