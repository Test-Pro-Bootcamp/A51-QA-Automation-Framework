import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);

        searchSong();
        clickViewAll();
        selectFirstSong();
        clickAddTo();
        choosePlaylist();

        WebElement verifyNotification = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertEquals(verifyNotification.getText(),"Added 1 song into \"Homework17SC.\"");



    }

    public void searchSong() throws InterruptedException {
        WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
        search.clear();
        search.sendKeys("Pluto");
        search.click();
        Thread.sleep(2000);
    }
    public void clickViewAll() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test ='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);
    }

    public void selectFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//*[@class='title'][contains(text(),'Pluto')]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickAddTo() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addTo.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Homework17SC')]"));
        playlist.click();
        Thread.sleep(2000);
    }



}
