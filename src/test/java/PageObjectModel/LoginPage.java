package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class LoginPage extends BasePage{

    //public WebElement findElement;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Locators
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");


    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    //private Actions findElement(By emailField) {
       // return null;
    //}
    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        findElement(submitBtn).click();
    }
    public void login(){
        provideEmail("adam.johnson@testpro.io");
        providePassword("1Te$t$tudent");
        clickSubmit();
    }


}
