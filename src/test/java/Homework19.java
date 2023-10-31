import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() {
        String confirmDelete = "playlist";
        this.openBrowser("https://qa.koel.app/");
        this.loginSite("kinjal.borad@testpro.io", "Ganesh#123");
        this.deleteSong();
        String x = this.getConfirmDelete();
        Assert.assertTrue(x.contains(confirmDelete));
        closeBrowser();
    }
}
