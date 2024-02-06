package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTests extends BaseTest {
    @Test
    public void countSongsInPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();
        homePage.clickAllSongs();

        int actualSongsQuantity = allSongsPage.countSongs();

        int visibleSongsQuantity = allSongsPage.extractVisibleQuantityOfAllSongs(allSongsPage.visibleQuantityOfSongsAndDuration());

        Assert.assertEquals(actualSongsQuantity, visibleSongsQuantity);
    }

    @Test
    public void songsDurationValue(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();
        homePage.clickAllSongs();

        String infoForDuration = allSongsPage.visibleQuantityOfSongsAndDuration();
        String calculatedDuration = allSongsPage.calculateTotalDurationOfAllSongs();
        String visibleDuration = allSongsPage.extractVisibleDurationOfAllSongs(infoForDuration);

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
