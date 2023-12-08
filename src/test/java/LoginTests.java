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

    public void loginValidEmailPassword(){
        LoginPage loginPage =new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());

  }
@Test
    public void loginValidEmailemptyPassword(){
        LoginPage loginPage =new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword(" ");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());

    }
@Test

    public void loginEmptyEmailValidPassword(){
        LoginPage loginPage =new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail(" ");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());
    }
@Test
    public void loginEmptyEmailEmptyPassword(){
        LoginPage loginPage =new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail(" ");
        loginPage.providePassword(" ");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());
    }

    @Test
    public void loginValidEmailInvalidPassword(){
        LoginPage loginPage =new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("abc ");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());

    }
    @Test
    public void loginInvalidEmailValidPassword(){
        LoginPage loginPage =new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("random@testpro.io");
        loginPage.providePassword("testpro135@ ");
        loginPage.clickSubmit();

        Assert.assertTrue(homepage.getRegistrationLink().isDisplayed());

    }

}



