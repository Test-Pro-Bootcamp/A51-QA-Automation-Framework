import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.UUID;

public class ProfileTests extends BaseTest {
    ProfilePage profilePage = new ProfilePage(getDriver());
    LoginPage loginPage = new LoginPage(getDriver());

    @Test
    public void changeProfileName()  throws InterruptedException {
        String randomNm = generateRandomName();
        String profileName = profilePage.getProfileName().toString();

        loginPage.loginValidCredentials();
        profilePage.clickAvatar()
            .provideCurrentPassword("te$t$tudent")
            .provideRandomProfileName(randomNm)
            .clickSave();
        Assert.assertEquals(profileName, randomNm);

    }
    private String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
