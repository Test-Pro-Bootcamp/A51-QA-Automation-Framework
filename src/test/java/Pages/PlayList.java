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
    public void searchField(String name){
        WebElement field = driver.findElement(By.cssSelector("input[type='search']"));
        field.clear();
        field.sendKeys(name);
    }
    public void provideViewAll(){
        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
    }
    public void choiceSong(){
        WebElement song = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class]"));
        song.click();
    }
    public void addToList(){
        WebElement buttonAdd = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        buttonAdd.click();
    }
    public void choiceList(){
        WebElement list = driver.findElement(By.xpath("//li[contains(text(),'new name for playlist')]"));
        list.click();
    }
    public String notificationMessage(){
        WebElement message = driver.findElement(By.cssSelector("div.success.show"));
        return message.getText();
    }
}
