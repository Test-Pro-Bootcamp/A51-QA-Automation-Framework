import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginSuccessTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar());
    }

   /* @Test
    public void loginEmptyEmailPassword() {
       navigateToLoginPage();
       clickSubmit();
       Assert.assertEquals(driver.getCurrentUrl(), url);
    }
     @Test
    public void loginValidEmailPassword(){

        //Steps
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
       // WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }
    @Test
    public void loginInvalidEmailValidPassword(){
        navigateToLoginPage();
        provideEmail("invalidemail@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        //comparison
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        //WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }
    @Test
    public void loginValidEmailEmptyPassword() {
        navigateToLoginPage();
        provideEmail("demo@class.com");
        clickSubmit();
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }*/

}
