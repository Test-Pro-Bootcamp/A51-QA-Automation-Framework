package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(css = "a.view-profile")
    WebElement profileIcon;

    @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public HomePage clickProfileIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.view-profile")));
        profileIcon.click();
        return this;
    }

    public boolean isAvatarDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        return avatarIcon.isDisplayed();
    }
}