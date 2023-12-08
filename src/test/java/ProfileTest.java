import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTest extends BaseTest{


    @Test
    public void changeNewPassword(){

        String updatedProfilePassword = "Profile updated.";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro1351@");
        loginPage.clickSubmit();

        homePage.clickProfileLink();

        profilePage.clickCurrentPasswordField("testpro1351@");
        profilePage.clickNewPasswordField("testpro135@");
        profilePage.clickSavePassword();

        Assert.assertEquals(profilePage.profileUpdateNotification(),updatedProfilePassword);
    }
}
