import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() {

        String confirmDelete = "playlist";
        this.openBrowser("https://qa.koel.app/");
        this.loginSite("demo@class.com", "te$t$tudent");
        this.deleteSong();
        String x = this.getConfirmDelete();
        Assert.assertTrue(x.contains(confirmDelete));
        closeBrowser();
    }
}

