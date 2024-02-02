package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AlbumsTests extends BaseTest {
    @Test
    public void countSongsInPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void songsDurationValue(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        homePage.clickAllSongs();
        String songsURL = "https://qa.koel.app/#!/songs";
        Assert.assertEquals(driver.getCurrentUrl(), songsURL);


        String infoForDuration = allSongsPage.visibleQuantityOfSongsAndDuration();
        String calculatedDuration = allSongsPage.calculateTotalDuration();
        String visibleDuration = allSongsPage.parseVisibleDurationOfSongs(infoForDuration);

        if (calculatedDuration.equals(visibleDuration)) {
            System.out.println("Calculated and visible durations match!");
        } else {
            System.out.println("Calculated and visible durations do not match!");
            System.out.println("Calculated Duration: " + calculatedDuration);
            System.out.println("Visible Duration: " + visibleDuration);
        }

        Assert.assertEquals(calculatedDuration, visibleDuration);
    }
}
