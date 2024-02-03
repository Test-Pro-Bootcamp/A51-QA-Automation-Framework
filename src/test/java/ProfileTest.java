import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;


public class ProfileTest extends BaseTest {

    @Test
    public void changeCurrentTheme()   {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.provideEmail("faizan.khan@testpro.io")
                .providePassword("master21")
                .clickSubmitBtn();

        homePage.clickProfileIcon();

        profilePage.chooseVioletTheme();

        Assert.assertTrue(profilePage.isVioletThemeSelected());

    }
}