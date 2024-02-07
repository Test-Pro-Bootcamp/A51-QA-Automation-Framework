package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
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

    public void enterNewName(){
        passwordInputField.click();
        passwordInputField.clear();
        passwordInputField.sendKeys("OPJKDUhA");
        nameInputField.click();
        nameInputField.clear();
        nameInputField.sendKeys(generateRandomName());
    }

    public String verifyNotificationMessage() {
        wait.until(ExpectedConditions.visibilityOf(notificationMessage));
        return notificationMessage.getText();
    }

}
