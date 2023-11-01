import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object [][]getDataFromDataProvider(){
        return new Object[][] {
                {"demo@class.com", "te$t$tudent"},
                {"invalidemail@class.com", "te$t$tudent"},
                {"demo@class.com", "InvalidPassword"},
                {"", ""}
        };

    }


    @Test(dataProvider = "LoginData")
    public void loginTests(String email, String password) throws InterruptedException{
       navigateToLoginPage();
       provideEmail(email);
       providePassword(password);
       clickSubmit();

       Thread.sleep(2000);
       Assert.assertEquals(driver.getCurrentUrl(), newURL);
    }
     @Test
    public void loginValidEmailPassword(){

        //Steps
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
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
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }
    @Test
    public void loginValidEmailInvalidPassword() {
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("InvalidPassword");
        clickSubmit();
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
