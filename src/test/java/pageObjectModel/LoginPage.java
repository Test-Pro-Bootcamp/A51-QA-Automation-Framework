package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // LOCATORS SELENIUM PAGE FACTORY
    @FindBy(css = "[type='email']")
     WebElement emailTxtField;
    @FindBy(css = "[type='password']")
     WebElement passwordTxtField;
    @FindBy(css = "[type='submit']")
     WebElement submitButton;

    @FindBy (css = "a[href='registration']")
     WebElement registrationLink;

    public LoginPage provideEmailToLogin(String email){
        emailTxtField.sendKeys(email);
        return this;
    }
    public LoginPage providePasswordToLogin(String password){
        passwordTxtField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn(){
        submitButton.click();
        return this;
    }
    public WebElement getRegistrationLink(){
        return findElement (registrationLink);
    }


    //LOCATORS BY
//     By emailField = By.cssSelector("input[type='email']");
//     By passwordField = By.cssSelector("input[type='password']");
//     By submitBtn = By.cssSelector("button[type='submit']");
//     By registrationLink = By.cssSelector("a[href='registration']");


//    public void provideEmail(String email){
//        findElement((WebElement) emailField).sendKeys(email);
//    }
//    public void providePassword(String password){
//        findElement((WebElement) passwordField).sendKeys(password);
//    }
//    public void clickSubmit(){
//        findElement((WebElement) submitBtn).click();
//    }
    public void provideLoginSucceed(){
        provideEmailToLogin("lolitamantsiuk@gmail.com");
        providePasswordToLogin("te$t$tudent");
        clickSubmitBtn();
    }


}
