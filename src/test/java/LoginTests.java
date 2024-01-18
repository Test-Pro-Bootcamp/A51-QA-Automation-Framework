import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.Reporter;


public class LoginTests extends BaseTest {

    @Test
    public void loginSuccessTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("adam.johnson@testpro.io").providePassword("1Te$t$tudent").clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar());
    }

    @Test
    public void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("incorrect@email.com").providePassword("1Te$t$tudent").clickSubmitBtn();
        loginPage.getRegistrationLink();
    }

    @Test
    public void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("adam.johnson@testpro.io").providePassword("AbraCadabra").clickSubmitBtn();
        loginPage.getRegistrationLink();
    }

    @Test
    public void loginEmptyEmailTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("").providePassword("1Te$t$tudent").clickSubmitBtn();
        loginPage.getRegistrationLink();
    }

    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("adam.johnson@testpro.io").providePassword("").clickSubmitBtn();
        loginPage.getRegistrationLink();
    }

}
