import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import java.util.List;

public class PlaylistTests extends BaseTest {
    @Test
    public void deletePlaylist() {

        LoginPage loginPage = new LoginPage(basePage.getDriver());
        loginPage.login();
        HomePage homepage = new HomePage(basePage.getDriver());
        homepage.getAddPlaylistButton().click();
        homepage.getNewPlaylistButton().click();

        String playlistName = "My Playlist";
        homepage.getPlaylistNameInput().sendKeys(playlistName);
        homepage.getPlaylistNameInput().sendKeys(Keys.RETURN);

        Assert.assertTrue(homepage.getAdditionSuccessElement().isDisplayed());

        homepage.getDeletePlaylistButton().click();

        Assert.assertTrue(homepage.getDeletionSuccessElement().isDisplayed());
    }
    @Test
    public void renamePlaylist() {
        String playlistName = "My Playlist";
        String newPlaylistName = "Renamed Playlist";

        LoginPage loginPage = new LoginPage(basePage.getDriver());
        loginPage.login();
        createPlaylist(playlistName);
        renamePlaylist(playlistName, newPlaylistName);

        HomePage homepage = new HomePage(basePage.getDriver());
        boolean isRenamed = false;
        List<WebElement> playlists = homepage.getPlaylists();
        for (WebElement playlist : playlists) {
            if (playlist.getText().equals(newPlaylistName)) {
                isRenamed = true;
            }
        }
        Assert.assertTrue(isRenamed);
    }

    private void createPlaylist(String name) {
        HomePage homepage = new HomePage(basePage.getDriver());
        homepage.getAddPlaylistButton().click();
        homepage.getNewPlaylistButton().click();
        homepage.getPlaylistNameInput().sendKeys(name);
        homepage.getPlaylistNameInput().sendKeys(Keys.RETURN);
    }

    private void renamePlaylist(String oldName, String newName) {
        HomePage homepage = new HomePage(basePage.getDriver());
        for (WebElement playlist: homepage.getPlaylists()) {
            if (playlist.getText().equals(oldName)) {
                basePage.contextClick(playlist);
                homepage.getEditButton().click();
                WebElement input = homepage.getPlaylistRenamingInput();
                input.sendKeys(Keys.CONTROL + "a");
                input.sendKeys(Keys.DELETE);
                input.sendKeys(newName);
                input.sendKeys(Keys.RETURN);
                break;
            }
        }
    }
}
