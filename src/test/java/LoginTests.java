import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {



    public void loginValidEmailPassword() {

        navigateToPage();
        provideEmail("jguy1@stny.rr.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar'"));

        Assert.assertTrue(avatar.isDisplayed());

    }
}
