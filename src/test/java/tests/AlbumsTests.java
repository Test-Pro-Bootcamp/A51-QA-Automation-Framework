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
            //WebElement shuffleIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='albumsWrapper']/div/article[1]/footer/p/span[2]/a[1]/i")));
            //Assert.assertTrue(shuffleIcon.isDisplayed());
            //Assert.assertTrue(shuffleIcon.isDisplayed(), "Shuffle icon is not displayed for album");
            albumsPage.scrollToElement(driver, albumIcon);
            albumsCount+=1;
        }

        albumsPage.scrollToBottom(driver);

        System.out.println("Checked albums: " + albumsCount );
    }

    @Test
    public void verifyDownloadIcon() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AlbumsPage albumsPage = new AlbumsPage(driver);

        loginPage.login();
        homePage.clickAlbums();

        albumsPage.hoverOverFirstAlbum();
        WebElement downloadIcon = wait.until(ExpectedConditions.visibilityOf(albumsPage.downloadIcon));
        Assert.assertTrue(downloadIcon.isDisplayed());
    }

    @Test
    public void verifyAlbumImage(){
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
            wait.until(ExpectedConditions.visibilityOf(albumsPage.albumCover));

            String actualCoverXPath = albumsPage.albumCover.getAttribute("xpath");

            String standartKoelCover = "//*[@id=\"albumsWrapper\"]/div/article[3]/span/span";
            if (actualCoverXPath != null && actualCoverXPath.equals(standartKoelCover)) {
                //if (actualCoverXPath.equals(standartKoelCover)) {
                System.out.println("Album has Koel cover");
                koelCover +=1;
            } else {
                System.out.println("Album has UNIQUE cover");
                uniqueCover +=1;
            }
            albumsCount +=1;
        }

        System.out.println("Koel covers: "+ koelCover);
        System.out.println("Unique covers: " + uniqueCover);
        System.out.println("All albums " + albumsCount);

    }

}
