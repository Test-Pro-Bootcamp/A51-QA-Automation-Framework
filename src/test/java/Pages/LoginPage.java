package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

   private By emailField = By.cssSelector("input[type='email']");
   private By passwordField = By.cssSelector("input[type='password']");
   private By submitBtn = By.cssSelector("button[type='submit']");

    private void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }

    private void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }

    private void clickSubmit(){
        findElement(submitBtn).click();
    }

    public void login(){
        provideEmail("sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
    }

}