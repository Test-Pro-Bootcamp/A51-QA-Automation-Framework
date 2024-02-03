import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import java.time.Duration;

public class LoginTests extends BaseTest {

        //Fluent interfaces example
        @Test
        public void loginInvalidEmailValidPassword() {

            LoginPage loginPage = new LoginPage(getDriver());

            loginPage.provideEmail("faizankhan@testpro.io")
                    .providePassword("master21")
                    .clickSubmit();

            Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://qa.koel.app/
        }
    @Test
    public void loginValidEmailPassword () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("faizan.khan@testpro.io")
                .providePassword("master21")
                .clickSubmitBtn();

        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @Test
    public void loginValidEmailEmptyPassword() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("faizan.khan@testpro.io")
                .providePassword("")
                .clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://qa.koel.app/
    }

    //    OR
    @Test
    public void loginEmptyEmailPassword() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("").providePassword("te$t$tudent").clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}


