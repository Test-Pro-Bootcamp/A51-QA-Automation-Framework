package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (xpath = "//*[@id=\"inputProfileName\"]")
    public WebElement nameInputField;
    @FindBy (xpath = "//*[@id=\"inputProfileCurrentPassword\"]")
    public WebElement passwordInputField;

    @FindBy (css = "button.btn-submit")
    public WebElement saveButton;

    @FindBy (css = "div.success.show")
    WebElement notificationMessage;

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public ProfilePage provideNewName(){
        nameInputField.click();
        nameInputField.clear();
        nameInputField.sendKeys(generateRandomName());
        return this;
    }

    public ProfilePage provideCurrentPassword(){
        passwordInputField.click();
        passwordInputField.clear();
        passwordInputField.sendKeys("OPJKDUhA");
        return this;
    }


    public String verifyNotificationMessage() {
        wait.until(ExpectedConditions.visibilityOf(notificationMessage));
        return notificationMessage.getText();
    }

}
