import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    //

    @Test
    public void loginSuccessTest() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("zhanna.ivanova@testpro.io")
                .providePassword("12345678")
                .clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar());
    }
    @Test
    public void loginInvalidCredentials(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("zhanna.ivanova@testpro.io")
                .providePassword("12345678")
                .clickSubmitBtn();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }



    public void waitForAnElementToBeVisible(String cssLocator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
    }


}