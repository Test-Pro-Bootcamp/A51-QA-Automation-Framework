import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException{

        String expectedSongAddedMessage = "Added 1 song into \"dasha.\"";

        navigateToLoginPage();
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();
        Thread.sleep(2000);

        searchField("birthday");
        provideViewAll();
        choiceSong();
        addToList();
        choiceList();


        Assert.assertEquals(notificationMessage(), expectedSongAddedMessage);

    }
    public void searchField(String name) throws InterruptedException{
        WebElement field = driver.findElement(By.cssSelector("input[type='search']"));
        field.clear();
        field.sendKeys(name);
        Thread.sleep(2000);
    }
    public void provideViewAll() throws InterruptedException{
        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void choiceSong() throws InterruptedException{
        WebElement song = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class]"));
        song.click();
        Thread.sleep(2000);
    }
    public void addToList() throws InterruptedException{
        WebElement buttonAdd = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        buttonAdd.click();
        Thread.sleep(2000);
    }
    public void choiceList() throws InterruptedException{
        WebElement list = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'dasha')]"));
        list.click();
        Thread.sleep(2000);
    }
    public String notificationMessage(){
        WebElement message = driver.findElement(By.cssSelector("div.success.show"));
        return message.getText();

    }
}
