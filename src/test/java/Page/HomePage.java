package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locator
    By nextSongIcon = By.xpath("//i[@title='Play next song']");
    By playIcon = By.xpath("//span[@title='Play or resume']");
    By expectedResult = By.xpath("//img[@alt='Sound bars']");

    public void getNextSong(){
        findElementLocator(nextSongIcon).click();
    }
    public void getPlay(){
        findElementLocator(playIcon).click();
    }
    public WebElement getResult(){
        return findElementLocator(expectedResult);
    }

}
