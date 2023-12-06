package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    //By emailField= By.cssSelector("[Type='email']");
    @FindBy(css = "[Type='email']")
     WebElement emailTxtField;

    @FindBy(css = "[Type='password']")
    WebElement passwordTxtField;
    @FindBy(css = "[Type='submit']")
    WebElement submitButtonLocator;

    @FindBy(xpath="//*[@id='app']/div/div/form/div[1]/img")
    WebElement koelIcon;

    @FindBy(css="[href ='registration']")
    WebElement registrationLink;

    public void provideEmail(String email) {
        emailTxtField.sendKeys(email);
    }
        public void providePassword (String password){
            passwordTxtField.sendKeys(password);
        }

        public void clickSubmit () {
            submitButtonLocator.click();
        }



    public  WebElement getRegistrationLink() {
        return registrationLink;

    }

//    public WebElement registrationLink() {
//        return null;
//    }
}