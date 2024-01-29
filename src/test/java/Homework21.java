import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    String newPlaylistName = "Love";
    @Test
    public void renamePlaylist(){
        String updatedplayListMsg = "Updated playlist \"Love.\"";
        //provideEmail("zhanna.ivanova@testpro.io");
        //providePassword("12345678");
        //clickSubmit();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlayListSuccessMsg(), updatedplayListMsg);
    }
    public void doubleClickPlaylist()  {
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName() {
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.CONTROL,"A", Keys.BACK_SPACE);
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getRenamePlayListSuccessMsg() {
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
