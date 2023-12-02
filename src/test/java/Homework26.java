import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework26 extends BaseTest{

    @Test

    public void validEmailValidPasswordLogin(){


        LoginPage loginPage= new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
