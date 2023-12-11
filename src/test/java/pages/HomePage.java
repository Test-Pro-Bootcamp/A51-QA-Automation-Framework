package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    //constructor
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //region Locators
    @FindBy (css = "[class='avatar']")
    WebElement userAvatarIcon;

    //By userAvatarIcon = By.cssSelector("img.avatar");
    //endregion

    //region Helper Methods
    public boolean getUserAvatar(){
         return userAvatarIcon.isDisplayed();//findElement(userAvatarIcon);
    }
    //endregion

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn'"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }
}
