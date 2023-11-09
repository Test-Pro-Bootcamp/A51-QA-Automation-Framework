import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist(){

        String actualMessage = "Deleted playlist \"playlist for homework 19.\"";

        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        clickOfPlaylist();
        deleteAct();

        Assert.assertEquals(notificationMessage(), actualMessage);
    }

    public void clickOfPlaylist(){
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section//a[contains (text(), 'playlist for homework 19')]")));
        playlist.click();
    }

    public void deleteAct(){
        WebElement deleteList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Delete this playlist']")));
        deleteList.click();

    }
    public String notificationMessage(){
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return message.getText();
    }

}
