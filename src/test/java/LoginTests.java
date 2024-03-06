import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test

    public void loginValidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro1357@");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginValidEmailemptyPassword() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword(" ");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());

    }

    @Test

    public void loginEmptyEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail(" ");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());
    }

    @Test
    public void loginEmptyEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail(" ");
        loginPage.providePassword(" ");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());
    }

    @Test
    public void loginValidEmailInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("abcd ");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());

    }

    @Test
    public void loginInvalidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("random@testpro.io");
        loginPage.providePassword("testpro135@ ");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());

    }

    @Test
    public void editProfile() {

        String updatedProfile = "Profile updated.";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro1357@");
        loginPage.clickSubmit();

        homePage.clickProfileLink();

        profilePage.clickCurrentPasswordField("testpro1357@");
        profilePage.clickNewPasswordField("testpro135@");
        profilePage.clickEmailField("aparajita.jha1@testpro.io");

        profilePage.clickSave();

        Assert.assertEquals(profilePage.profileUpdateNotification(), updatedProfile);
    }

    @Test

    public void loginUpdatedEmailUpdatedPassword() {
        String updatedPassword = "testpro135@";
        String updatedEmail = "aparajita.jha1@testpro.io";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail(updatedEmail);
        loginPage.providePassword(updatedPassword);
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginUpdatedEmailOldPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha1@testpro.io");
        loginPage.providePassword("testpro1357@");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());

    }

    @Test
    public void loginOldEmailUpdatedPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());

    }

}




