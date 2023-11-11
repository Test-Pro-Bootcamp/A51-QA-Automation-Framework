import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Homework23 extends BasePage {

    public Homework23(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test

    public void renamePlaylist()throws InterruptedException{

        String updatedPlaylistName= "updated playlist \"melodious album.\" ";

        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("aparajita.jha@testpro.io");
        loginPage.providePassword("testpro135@");
        loginPage.clickSubmit();
        Thread.sleep(2000);
        homePage.contextClickPlaylist();
        homePage.clickEdit();
        homePage.enterNewPlaylistName("melodious album");

        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),updatedPlaylistName);

    }
}
