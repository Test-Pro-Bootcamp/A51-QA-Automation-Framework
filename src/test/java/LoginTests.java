import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test(dataProvider = "LoginData")
    public void loginTests(String email, String password) throws InterruptedException{
    navigateToLoginPage();
    provideEmail(email);
    providePassword(password);
    clickSubmit();
    Thread.sleep(2000);
    //Assert.assertEquals(driver.getCurrentUrl(), url);
    WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
    Assert.assertTrue(avatar.isDisplayed());

    }

    @Test
    public void loginValidEmailPassword(){
        navigateToLoginPage();
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
    }
    @Test
    public void loginInvalidEmailValidPassword(){
        navigateToLoginPage();
        provideEmail("invalidEmail@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void loginValidEmailInvalidPassword() throws InterruptedException{
        navigateToLoginPage();
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("InvalidPassword");
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
    }

}
