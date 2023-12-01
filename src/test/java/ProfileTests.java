import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.ProfilePage;

public class ProfileTests extends BaseTest {
    @Test
    public void changeProfileName() {

        LoginPage loginPage = new LoginPage(basePage.getDriver());
        loginPage.login();

        HomePage homePage = new HomePage(basePage.getDriver());
        homePage.getAvatarIcon().click();

        ProfilePage profilePage = new ProfilePage(basePage.getDriver());
        String randomName = profilePage.generateRandomName();

        profilePage.getProfileNameInput().clear();
        profilePage.getProfileNameInput().sendKeys(randomName);
        profilePage.getSaveButton().click();

        Assert.assertEquals(homePage.getProfileName().getText(), randomName);
    }
}

