package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.BaseTest;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("alina.nikolaienko@testpro.io")
                .providePassword("OPJKDUhA")
                .clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginEmptyEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("")
                .providePassword("")
                .clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getUrl());
    }

    @Test
    public void loginInvalidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("alina.nikolaienko@testpro.io")
                .providePassword("qwerty")
                .clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getUrl());
    }

    @Test
    public void loginValidEmailInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("email@gmail.com")
                .providePassword("OPJKDUhA")
                .clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getUrl());
    }

    @Test (dataProvider = "InvalidLoginData", dataProviderClass = BaseTest.class)
    public void unableLoginWithDataProvider(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail(email)
                .provideEmail(password)
                .clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getUrl());
    }


    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void loginWithDataProvider(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail(email)
                .providePassword(password)
                .clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
