import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test(dataProvider = "LoginData")
    public void deletePlaylist(String email, String password) throws InterruptedException {
        String expectedPlaylistDeletedNotification = "Deleted playlist";

        navigateToLoginPage();
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        Thread.sleep(2000);

        clickPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistNotification().contains(expectedPlaylistDeletedNotification));



    }

    public void clickPlaylist() {
        WebElement myPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        myPlaylist.click();
    }

    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        deletePlaylist.click();
        Thread.sleep(2000);

    }
    public String getDeletedPlaylistNotification(){
        WebElement notification = driver.findElement(By.cssSelector("[class='success show']"));
        return notification.getText();
    }
}
