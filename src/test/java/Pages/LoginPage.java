package Pages;

import Pages.BasePage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver dr){ super(dr); }

    @FindBy(css = "[type='email']")
    private WebElement emailField;

    @FindBy(css = "[type='password']")
    private WebElement pswdField;

    @FindBy(css = "[type='submit']")
    private WebElement submitBtn;
    //By emailField = By.cssSelector("input[type='email']");
    //By pswdField = By.cssSelector("input[type='password']");
    //By submitBtn = By.cssSelector("button[type='submit']");
    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password){
        pswdField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit(){
        //click(submitBtn);
        submitBtn.click();
        return this;
    }
    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }

}
