import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

//      Added ChromeOptions argument below to fix websocket error
        String adConfirm = "Added 1 song into \" kinjal \"";
        openBrowser("https://qa.koel.app/");
        loginSite("demo@class.com", "te$t$tudent");

        klSearch("midnight");

        Assert.assertEquals(GetSuccess(), adConfirm);
        //Test Comment
        closeBrowser();

    }

}
