package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locator
    By userAvatarIcon = By.cssSelector("img.avatar");

    //Helper
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public WebElement hoverPlay(){
        WebElement play = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }
}
