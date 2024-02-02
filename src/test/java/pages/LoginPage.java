package pages;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = "input[type='email']")
    private WebElement emailField;

    @FindBy (css = "input[type='password']")
    private WebElement passwordField;

    @FindBy (css = "button[type='submit']")
    private WebElement submitBtn;


    public LoginPage provideEmail (String email){
        //WebElement emailElement = driver.findElement(By.cssSelector("input[type='email']"));
        //WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        //WebElement emailElement = findElement((WebElement) emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
        return this;
    }



    public LoginPage providePassword (String password){
        //WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password']"));
        //WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        //WebElement passwordElement = findElement((WebElement) passwordField);
        passwordElement.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit(){
        //WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        //WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        //findElement((WebElement) submitButton).click();
        submitButton.click();
        return this;
    }

    public void login(){
        provideEmail("alina.nikolaienko@testpro.io");
        providePassword("OPJKDUhA");
        clickSubmit();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }


    /*

    public boolean isLoggedOut() {
        return findElement(passwordField).isDisplayed();
    }

    public boolean isDisplayedButtonSubmitLogin() {
        return findElement(submitBtn).isDisplayed();
    }

    public String getTextEmailValidationMessage() {
        return findElement(emailField).getAttribute("validationMessage");
    }

    public boolean isEmailValidationMessagePresent(String messageError) {
        String validationMessage = findElement(emailField).getAttribute("validationMessage");
        return validationMessage.contains(messageError);
    }

    public WebElement getSubmitLoginButton() {
        return findElement(submitBtn);
    }

     */

}
