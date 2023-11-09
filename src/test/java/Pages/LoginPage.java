package Pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver dr){ super(dr); }
    By emailField = By.cssSelector("input[type='email']");
    By pswdField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");
    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(pswdField).sendKeys(password);
    }
    public void clickSubmit(){
        click(submitBtn);
    }
    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }

}
