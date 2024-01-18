package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
//locators
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    // Represents the email input field on the login form.

    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    // Represents the password input field on the login form.

    @FindBy(css = "button[type='submit']")
    private WebElement submitButtonLocator;
    // Represents the submit button on the login form.

    @FindBy(xpath = "//a[@href='registration']")
    private WebElement registrationLink;

    @FindBy(css = ".fa-sign-out")
    private WebElement logoutBtn;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
    }

    public void loginValidCredentials() {
        provideEmail("adam.johnson@testpro.io");
        providePassword("1Te$t$tudent");
        clickSubmitBtn();
    }
    public LoginPage clickLogoutBtn(){
        logoutBtn.click();
        return this;
    }
    public void getRegistrationLink(){
    }
}
