import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test
    public static void loginEmptyEmailPasswordTest() {
        //changed for cloud test
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("");
        loginPage.providePassword("12345678");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
    @Test
    public  static void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("zhanna.ivanova@testpro.io");
        loginPage.providePassword("1234678");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());

    }
    @Test
    public static void loginEmptyPasswordTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("zhanna.ivanova@testpro.io");
        loginPage.providePassword("");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());

    }

    @Test
    public static void loginWrongEmailTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("zhana.ivanova@testpro.io");
        loginPage.providePassword("12345678");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
    @Test
    public void loginSucceedTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.provideLoginSucceed();
        Assert.assertTrue(homePage.getUserAvatar());
    }
}

