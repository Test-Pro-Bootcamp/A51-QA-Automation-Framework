import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21Test extends BaseTest {

    String renameSuccessMsg = "Updated playlist \"Test Play2.\"";


    @Test
    public void renamePlaylist() {
        //Pre-Conditions-user must have a playlist created
        //Login
        navigateToPage();
        provideEmail("sade.harris@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        //Step1
        selectPlaylist();
        //Step2
        clickEdit();
        //Step3
        playlistNewName();
        //Verify Playlist was renamed
        Assert.assertEquals(getRenameSuccessMsg(),renameSuccessMsg);


    }

    public void selectPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#!/playlist/78934']")));
        actions.contextClick(driver.findElement(By.xpath("//a[@href='#!/playlist/78934']"))).perform();

    }

    public void clickEdit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-testid='playlist-context-menu-edit-78934']")));
        actions.click(driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-edit-78934']"))).perform();
    }

    public void playlistNewName() {
        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistNameField.sendKeys("Test Play2");
        playlistNameField.sendKeys(Keys.ENTER);
    }
        public String getRenameSuccessMsg () {
            WebElement displayedRenameSuccessMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
            return displayedRenameSuccessMsg.getText();
        }
    }
