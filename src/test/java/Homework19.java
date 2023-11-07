import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException{

        String actualMessage = "Deleted playlist \"playlist for homework 19.\"";
        navigateToLoginPage();
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();
        Thread.sleep(2000);

        clickOfPlaylist();
        deleteAct();

        Assert.assertEquals(notificationMessage(), actualMessage);
    }

    public void clickOfPlaylist(){
        WebElement playlist = driver.findElement(By.cssSelector("a[class='active']"));
        playlist.click();
    }

    public void deleteAct(){
        WebElement deleteList = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deleteList.click();
    }
    public String notificationMessage(){
        WebElement message = driver.findElement(By.cssSelector("div.success.show"));
        return message.getText();
    }
}
