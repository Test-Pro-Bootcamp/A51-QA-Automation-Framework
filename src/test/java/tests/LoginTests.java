package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test (dataProvider = "InvalidLoginData", dataProviderClass = BaseTest.class)
    public void unableLoginWithDataProvider(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void loginWithDataProvider(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Thread.sleep(2000);
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }


    @Test
    public void loginEmptyEmailPassword() {
        navigateToPage();
        provideEmail("");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginInvalidEmailValidPassword() {
        navigateToPage();
        provideEmail("incorrectemail@testpro.io");
        providePassword("OPJKDUhA");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailValidPassword() {
        navigateToPage();
        provideEmail("alina.nikolaienko@testpro.io");
        providePassword("OPJKDUhA");
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }
}
