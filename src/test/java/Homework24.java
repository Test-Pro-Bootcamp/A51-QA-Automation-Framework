import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework24 extends BaseTest{

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
