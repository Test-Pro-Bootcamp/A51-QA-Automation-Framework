import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{

    @Test
    public void addSongToPlaylist(){
        LoginPage loinPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        
        String expectedSongAddedMessage = "Added 1 song into \"dasha.\"";

        loinPage.provideEmailToLogin("daria.chebotnyagina@testpro.io")
                .providePasswordToLogin("Asdfasdf1")
                .clickSubmitBtnToLogin();

        homePage.searchField("birthday")
                .provideViewAll()
                .choiceSong()
                .addToList()
                .choiceList();

        Assert.assertEquals(homePage.notificationMessage(), expectedSongAddedMessage);
    }

}
