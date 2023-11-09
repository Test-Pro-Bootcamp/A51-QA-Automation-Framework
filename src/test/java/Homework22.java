import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    @Test
    public void renamePlaylist(){
        String newPlaylistName = "Test Playlist";
        String updatedPlaylistMsg = "Updated playlist \"Test Playlist.\"";

        this.openBrowser("https://qa.koel.app/");

        LoginPage lPage = new LoginPage(driver);
        HomePage hPage = new HomePage(driver);

        lPage.login();
        hPage.doubleClickPlaylist();
        hPage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(hPage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
        this.closeBrowser();

    }
}
