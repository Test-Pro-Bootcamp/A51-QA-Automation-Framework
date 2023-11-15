import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


    public class Homework24 extends BaseTest {

        @Test
        public void deletePlaylist() throws InterruptedException {

            String expecteddeletedPlaylistmsg = "Deleted playlist \"test pro playlist.\"";

            provideEmail("aparajita.jha@testpro.io");
            providePassword("testpro135@");
            clickSubmit();
            Thread.sleep(2000);
            openPlaylist();
            clickDeletePlaylistBtn();


            Assert.assertEquals(getPlaylistDeletedmsg(), expecteddeletedPlaylistmsg);

        }

        public String getPlaylistDeletedmsg() {
            WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
            return notification.getText();
        }

        public void openPlaylist() {
            WebElement playlist = driver.findElement(By.cssSelector(".playlist:nth-child(3"));

            playlist.click();


        }

        public void clickDeletePlaylistBtn() throws InterruptedException {
            WebElement deletePlaylist = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
            deletePlaylist.click();
            Thread.sleep(2000);
        }

    }

