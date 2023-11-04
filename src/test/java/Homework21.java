import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;


public class Homework21 extends BaseTest{

    @Test
public void renamePlaylist(){
    String getNewPlaylistname = "Updated playlist 'test.'";

    provideEmail("aparajita.jha@testpro.io");
    providePassword("testpro135@");
    clickSubmit();
    //choosePlaylist();
    contextClickPlaylist();
    clickEdit();
    newPlaylistName();
    //Assert.assertEquals(getRenamePlaylistSuccessMsg() , getNewPlaylistName);
}

    public void contextClickPlaylist() {

        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.contextClick(playlist).perform();

    }
    public void clickEdit(){
        WebElement edit=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]/nav/ul/li[1]")));
     actions.click(edit).perform();
    }
    public void newPlaylistName(){
    WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));

    playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE ));
    playlistInputField.sendKeys("test");
    playlistInputField.sendKeys(Keys.ENTER);
}

}
