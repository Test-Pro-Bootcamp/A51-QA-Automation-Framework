import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{

    @Test
    public void playSongTest(){
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        loginpage.login();

        homepage.getPlayNextSong();
        homepage.getPlay();

        Assert.assertTrue(homepage.getResult().isDisplayed());
    }

}
