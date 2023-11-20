import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginSuccessTest() {
        LoginPage loginPage =  new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("fake@fakeaccount.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar());
    }
}
