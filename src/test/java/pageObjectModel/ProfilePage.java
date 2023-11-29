package pageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = "[name='current_password']")
    WebElement currentPasswordField;
    @FindBy (css = "[name='name']")
    WebElement profileName;
    @FindBy (css = "button.btn-submit")
    WebElement saveBtn;


    public void provideCurrentPassword (String currentPassword){
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }
    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }
    public void provideProfileName(String name){
        profileName.clear();
        profileName.sendKeys(name);
    }
    public void clickSave(){
        saveBtn.click();
    }

}
