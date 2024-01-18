import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        String randomName = generateRandomName();
        String profileName = profilePage.getProfileName().toString();
        loginPage.loginValidCredentials();
        profilePage.clickAvatar().provideCurrentPassword("1Te$t$tudent").provideRandomProfileName(randomName).clickSave();
        Assert.assertEquals(profileName, randomName);
    }

    private String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Test
    public void changePassword(){
        String updatedProfilePassword = "Profile updated.";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        loginPage.provideEmail("adam.johnson@testpro.io").providePassword("1Te$t$tudent").clickSubmitBtn();
        homePage.clickProfileLink();
        profilePage.clickSave();
    }

    @Test public void changeThemeColor(){

    }
}

