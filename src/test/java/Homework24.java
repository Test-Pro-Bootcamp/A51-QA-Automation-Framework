import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class Homework24 extends BaseTest {


        @Test

        public void validemailvalidpasswordlogin(){

           // String updatedPlaylistName= "Updated playlist \"melodious album.\"";

            LoginPage loginPage= new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            loginPage.provideEmail("aparajita.jha@testpro.io");
            loginPage.providePassword("testpro135@");
            loginPage.clickSubmit();

            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        }




    }

