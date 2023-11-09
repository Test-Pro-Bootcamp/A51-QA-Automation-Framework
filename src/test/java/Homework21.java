import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() throws InterruptedException {
        String ExconfirmMessage = "Updated playlist";
        this.openBrowser("https://qa.koel.app/");
        this.loginSite("demo@class.com", "te$t$tudent");
        String FnConfirmMessage =  this.renameKLPlaylist();
        Assert.assertTrue(FnConfirmMessage.contains(ExconfirmMessage));
        closeBrowser();
    }
}
