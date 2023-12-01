import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test
public static void loginSuccessTest(){
        //changed for cloud test
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.provideLoginSucceed();
        Assert.assertTrue(homePage.getUserAvatar());


    }


}