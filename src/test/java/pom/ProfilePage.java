package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By profileNameInput = By.cssSelector("[name='name']");
    By submitButton = By.cssSelector("button[type='submit']");
    By saveButton = By.cssSelector("button.btn-submit");
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public WebElement getProfileNameInput() {
        return findElement(profileNameInput);
    }
    public WebElement getSubmitButton() {
        return findElement(submitButton);
    }
    public WebElement getSaveButton() {
        return findElement(saveButton);
    }
}
