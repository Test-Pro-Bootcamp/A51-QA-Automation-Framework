import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class MediaPlayerTest extends BaseTest{

    @Test
    public void playSong(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();


        homePage.nextSongPlay();
        homePage.currentSongPlay();

        Assert.assertTrue(homePage.isSongPlaying());



    }


}
