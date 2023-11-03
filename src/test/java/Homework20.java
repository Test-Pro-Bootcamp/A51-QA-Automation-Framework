import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;




public class Homework20 extends BaseTest{

        @Test
        public void deletePlaylist(){

            String expecteddeletedPlaylistmsg ="Deleted playlist \"test pro playlist.\"";

            provideEmail("aparajita.jha@testpro.io");
            providePassword("testpro135@");
            clickSubmit();
            //Thread.sleep(2000);
            openPlaylist();
            clickDeletePlaylistBtn();


            Assert.assertEquals(getPlaylistDeletedmsg(),expecteddeletedPlaylistmsg);

        }

        public String getPlaylistDeletedmsg() {
            WebElement notification =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
            return notification.getText();
        }

        public void openPlaylist(){
            WebElement playlist= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3")));

            playlist.click();

        }
    public void clickDeletePlaylistBtn(){
        WebElement deletePlaylist=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        deletePlaylist.click();

    }
}
