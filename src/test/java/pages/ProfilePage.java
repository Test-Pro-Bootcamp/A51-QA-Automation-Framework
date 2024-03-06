package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "[name='current_password']")
    WebElement currentPasswordField;

    @FindBy(css="[name='new_password']")
    WebElement newPasswordField;

    @FindBy(xpath="//*[@id=\"inputProfileEmail\"]")
    WebElement emailField;
    @FindBy(css="button.btn-submit")
    WebElement saveButton;

    @FindBy(css="div.success.show")
    WebElement successNotification;



    public ProfilePage clickCurrentPasswordField(String password) {
       click(currentPasswordField);
       currentPasswordField.sendKeys(password);
       return this;
    }
    public ProfilePage clickNewPasswordField(String password){
        click(newPasswordField);
        newPasswordField.sendKeys(password);
        return this;

    }
    public ProfilePage clickEmailField(String newEmail) {
        click(emailField);
        emailField.clear();
        emailField.sendKeys(newEmail);
        return this;
    }

        public ProfilePage clickSave () {
            click(saveButton);
            return this;
        }
        public String profileUpdateNotification () {
            return findElement(successNotification).getText();
        }

    }