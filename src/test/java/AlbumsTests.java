import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlbumsPage;
import pages.LoginPage;

public class AlbumsTests extends BaseTest{
    LoginPage loginPage = new LoginPage(getDriver());
    AlbumsPage albumsPage = new AlbumsPage(getDriver());
    @Test
    public void playFirstAlbumSongs() {
        loginPage.loginValidCredentials();
        albumsPage.navigateToAlbums()
                .rightClickAlbum()
                .selectPlayAll();
        Assert.assertTrue(albumsPage.checkAlbumSongPlaying());
    }
}
