import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @DataProvider(name="LoginData")
    public Object[][] getDataFromDataProvider() {
        return new Object[][] {
                {"jguy1@stny.rr.com", "te$t$tudent"}
        };
    }

    @Test(dataProvider = "LoginData")
    public void LoginValidEmailPassword() throws InterruptedException {
        //steps
        navigateToPage();
        provideEmail("jguy1@stny.rr.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar'"));
        Thread.sleep(2000);
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());

    }
}
