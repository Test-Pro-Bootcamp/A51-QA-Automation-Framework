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
    private WebElement emailTxtField;
    @FindBy(css = "[type='password']")
    private WebElement passwordTxtField;
    @FindBy(css = "[type='submit']")
    private WebElement submitLoginButton;


    //Helper methods using Selenium Page Factory

    public LoginPage provideEmailToLogin(String email){
        emailTxtField.sendKeys(email);
        return this;
    }
    public LoginPage providePasswordToLogin(String password){
        passwordTxtField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtnToLogin(){
        submitLoginButton.click();
        return this;
    }


}





