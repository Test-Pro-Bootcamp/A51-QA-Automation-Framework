import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword(){
        navigateToLoginPage();
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(),url);

    }
    @Test
    public  void loginValidEmailPassword(){
        //Steps
        navigateToLoginPage();
        provideEmail("hassan.mahim@testpro.io");
        providePassword("YOUSSEf2017$");
        clickSubmit();
        webElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }
    @Test
    public void loginInValidEmailPassword(){
        navigateToLoginPage();
        provideEmail("hassan.mahim@testpro.io");
        providePassword("YOUSSEf2017$");
        clickSubmit();
        webElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }
}
