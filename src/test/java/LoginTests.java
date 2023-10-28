import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

@Test (enabled = false, priority = 2, description = "Login with invalid email and valid password")
public void loginInvalidEmailValidPassword(){
        navigateToPage();
        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
        }
@Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
public void loginValidEmailPassword(){

        navigateToPage();
        provideEmail("ramil.hasanli@testpro.io");
        providePassword("iutZVH7Q");
        clickSubmit();
        isAvatarDisplayed();
        }

@Test (enabled = false, priority = 3, description = "Login with valid email and empty password")
public void loginValidEmailEmptyPassword() {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
        }

        }