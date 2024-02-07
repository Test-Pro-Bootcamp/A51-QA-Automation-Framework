package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.UUID;

public class ProfileTests extends BaseTest {
    @Test
    public void changeProfileName()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();
        homePage.clickProfileIcon();
        profilePage.provideCurrentPassword()
                .provideNewName()
                .clickSaveButton();

        Assert.assertEquals(profilePage.verifyNotificationMessage(), "Profile updated.");
    }

}
