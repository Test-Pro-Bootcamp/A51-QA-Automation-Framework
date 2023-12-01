import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;


public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() {

        LoginPage loginPage = new LoginPage(basePage.getDriver());
        loginPage.login();
        HomePage homePage = new HomePage(basePage.getDriver());
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}