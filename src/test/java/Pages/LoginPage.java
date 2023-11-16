package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage {
WebDriver driver;
WebDriverWait wait;

//locators
    By submitBtn = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By registrationForgotPassBtn = By.cssSelector("[href='registration']");
    
    public LoginPage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void provideEmail (String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.sendKeys(email);
    }
    public void providePassword (String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submit = driver.findElement(submitBtn);
        submit.click();
    }
    public void clickRegistrationForgotPass () {
        WebElement registrationForgotPass = driver.findElement(registrationForgotPassBtn);
        registrationForgotPass.click();
    }
}
