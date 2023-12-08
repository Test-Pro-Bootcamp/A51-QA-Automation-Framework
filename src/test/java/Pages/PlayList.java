package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PlayList extends BasePage {
    public PlayList(WebDriver givenDriver) {
        super(givenDriver);
    }
    String newPlaylistName = "new name for playlist";

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName(){
        WebElement newNamePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        newNamePlaylist.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        newNamePlaylist.sendKeys(newPlaylistName);
        newNamePlaylist.sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
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
