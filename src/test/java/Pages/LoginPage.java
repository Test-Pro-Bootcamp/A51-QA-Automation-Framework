package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css="[type='email']")
    WebElement emailTxtField;
    @FindBy(css="[type='password']")
    WebElement passwordTxtField;
    @FindBy(css="[type='submit']")
    WebElement submitBtNField;

    //Locators
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void provideSubmit(){
        findElement(submitBtn).click();
    }
    public void login(){
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        provideSubmit();
    }

    //Helper methods using Page Factory
    public LoginPage provideEmailToLogin(String email){
        emailTxtField.sendKeys(email);
        return this;
    }
    public LoginPage providePasswordToLogin(String password){
        passwordTxtField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtnToLogin(){
        submitBtNField.click();
        return this;
    }
}
