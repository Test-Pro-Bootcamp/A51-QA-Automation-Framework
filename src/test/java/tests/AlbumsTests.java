package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlbumsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class AlbumsTests extends BaseTest {
    @Test
    public void verifyShuffleIcon() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AlbumsPage albumsPage = new AlbumsPage(driver);

        loginPage.login();
        homePage.clickAlbums();

        List<WebElement> albumIcons = albumsPage.getAllAlbumIcons();
        int albumsCount = 0;

        for (WebElement albumIcon : albumIcons) {
            albumsPage.hoverOverElement(albumIcon);

            albumsCount += 1;
            Assert.assertTrue(albumsPage.shuffleIcon.isDisplayed(), "No shuffle icon");
            //Assert.assertTrue(albumsPage.shuffleIcon.isDisplayed());

            albumsPage.scrollToElement(driver, albumIcon);
        }

        System.out.println("Checked shuffle icons for " + albumsCount + " albums");
    }

    @Test
    public void verifyDownloadIcon() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AlbumsPage albumsPage = new AlbumsPage(driver);

        loginPage.login();
        homePage.clickAlbums();

        //albumsPage.hoverOverFirstAlbum();
        //WebElement downloadIcon = wait.until(ExpectedConditions.visibilityOf(albumsPage.downloadIcon));
        //Assert.assertTrue(downloadIcon.isDisplayed());

        List<WebElement> albumIcons = albumsPage.getAllAlbumIcons();
        int albumsCount = 0;

        for (WebElement albumIcon : albumIcons) {
            albumsPage.hoverOverElement(albumIcon);

            albumsCount += 1;
            Assert.assertTrue(albumsPage.getDownloadIcon().isDisplayed(), "No shuffle icon");

            albumsPage.scrollToElement(driver, albumIcon);
        }
        System.out.println("Checked download icons for " + albumsCount + " albums");
    }

    @Test
    public void verifyAlbumImage() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AlbumsPage albumsPage = new AlbumsPage(driver);

        loginPage.login();
        homePage.clickAlbums();

        List<WebElement> albumIcons = albumsPage.getAllAlbumIcons();
        int albumsCount = 0;
        int koelCover = 0;
        int uniqueCover = 0;

        for (WebElement albumIcon : albumIcons) {
            albumsPage.hoverOverElement(albumIcon);

            WebElement koelCoverElement = albumIcon.findElement(By.xpath("//*[@id=\"albumsWrapper\"]/div/article[3]/span/span"));

            if (koelCoverElement.isDisplayed()) {
                System.out.println("Album has Koel cover");
                koelCover += 1;
            } else {
                System.out.println("Album has UNIQUE cover");
                uniqueCover += 1;
            }
            albumsCount += 1;
            Assert.assertTrue(albumIcon.isDisplayed());
        }

        System.out.println("Koel covers: " + koelCover);
        System.out.println("Unique covers: " + uniqueCover);
        System.out.println("All albums " + albumsCount);

    }

    @Test
    public void verifyAlbumNameIsPresent() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AlbumsPage albumsPage = new AlbumsPage(driver);

        loginPage.login();
        homePage.clickAlbums();

        List<WebElement> albumNames = albumsPage.getAllAlbumNames();
        int countAlbum = 0;

        for (WebElement nameElement : albumNames) {
            Assert.assertTrue(nameElement.isDisplayed(), "Album name is not displayed: " + nameElement.getText());
            countAlbum+=1;
            System.out.println("Album name " + nameElement.getText());
        }
        System.out.println("Checked album names in " + countAlbum + " albums");

    }

    @Test
    public void verifyArtistNameIsPresent() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AlbumsPage albumsPage = new AlbumsPage(driver);

        loginPage.login();
        homePage.clickAlbums();

        List<WebElement> artistName = albumsPage.getAllArtistNames();
        int countArtists = 0;

        for (WebElement nameElement : artistName) {
            Assert.assertTrue(nameElement.isDisplayed(), "Artist name is not displayed: " + nameElement.getText());
            countArtists+=1;
            System.out.println("Artist name " + nameElement.getText());
        }
        System.out.println("Checked artist names in " + countArtists + " albums");
    }
}
