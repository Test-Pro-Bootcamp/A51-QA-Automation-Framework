import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPLayListDeletedMessage = "Deleted playlist \"Golden Girls.\"";

        provideEmail("adam.johnson@testpro.io");
        providePassword("1Te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPLayListDeletedMessage);
    }

}