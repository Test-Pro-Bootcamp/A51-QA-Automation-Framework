package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locator
    By playNextSongIcon = By.xpath("//i[@title='Play next song']");
    By playIcon = By.xpath("//span[@title='Play or resume']");
    By result = By.xpath("//img[@alt='Sound bars']");

    public void getPlayNextSong(){
        findElement(playNextSongIcon).click();
    }
    public void getPlay(){
        findElement(playIcon).click();
    }
    public WebElement getResult(){
        return findElement(result);
    }
}
