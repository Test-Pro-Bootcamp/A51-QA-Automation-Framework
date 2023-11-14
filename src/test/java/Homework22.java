import Page.HomePage;
import Page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{

    @Test
    public void playSongTest(){
        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginpage.login();

        homePage.getNextSong();
        homePage.getPlay();


        Assert.assertTrue(homePage.getResult().isDisplayed());
    }

}
