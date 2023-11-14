package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    public void provideEmail(String email){
        findElementLocator(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElementLocator(passwordField).sendKeys(password);
    }
    public void provideSubmit(){
        findElementLocator(submitBtn).click();
    }
    public void login(){
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        provideSubmit();
    }
}
