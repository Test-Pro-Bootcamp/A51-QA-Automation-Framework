package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    //Locators using Selenium Page Factory
    @FindBy(css = "[type='email']")
    WebElement emailTxtField;
    @FindBy(css = "[type='password']")
    WebElement passwordTxtField;
    @FindBy(css = "[type='submit']")
    WebElement submitLoginButton;


    //Helper methods using Selenium Page Factory

    public void provideEmailToLogin(String email){
        emailTxtField.sendKeys(email);
    }
    public void providePasswordToLogin(String password){
        passwordTxtField.sendKeys(password);
    }
    public void clickSubmitBtnToLogin(){
        submitLoginButton.click();
    }


}





