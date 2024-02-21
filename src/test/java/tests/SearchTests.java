package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;


public class SearchTests extends BaseTest {
    @Test
    public void verifySearchFromHomePage_80382() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        loginPage.login();
        String songName = "Reactor";
        homePage.enterSongsName(songName);
        searchPage.verifySongsResult();

        Assert.assertTrue(searchPage.verifySongsResult().contains(songName));
    }

    @Test //issue INTERNSHIP-80407
    public void verifySearchBySongs_80389 () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        loginPage.login();
        String songName = "Pluto";
        homePage.enterSongsName(songName);
        searchPage.verifyResultsInSongsSection();

        Assert.assertTrue(searchPage.verifyResultsInSongsSection().contains(songName));
    }

    @Test //issue INTERNSHIP-80407
    public void verifySearchByArtist_80393 () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        loginPage.login();
        String artistName = "Unknown";
        homePage.enterSongsName(artistName);
        searchPage.verifyResultsInArtistSection();

        Assert.assertTrue(searchPage.verifyResultsInArtistSection().contains(artistName));
    }

    @Test //issue INTERNSHIP-80407
    public void verifySearchByAlbum_80395 () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        loginPage.login();
        String albumName = "Unknown";
        homePage.enterSongsName(albumName);
        searchPage.verifyResultsInAlbumSection();

        Assert.assertTrue(searchPage.verifyResultsInAlbumSection().contains(albumName));
    }

    @Test //issue INTERNSHIP-80423
    public void verifySearchAfterInvalidData_80402 () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        loginPage.login();
        String invalidName = "qwerty";
        homePage.enterSongsName(invalidName);
        //String songSect = searchPage.verifyResultsInSongsSection();
        String albumSect = searchPage.verifyResultsInAlbumSection();
        String artistSect = searchPage.verifyResultsInArtistSection();

        Assert.assertTrue(albumSect.contains(invalidName));
    }

    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void verifyIgnoringWhiteSpaces_80403(String email, String password) {
        loginIntoKoel(email, password);

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchField.clear();
        String songNameSpacesBefore = "    Reactor";
        searchField.sendKeys(songNameSpacesBefore);
        songNameSpacesBefore = songNameSpacesBefore.replaceAll("\\s", "");

        WebElement songInSearchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']")));
        String mySongsInSearchResults = songInSearchResults.getText();

        Assert.assertTrue(mySongsInSearchResults.contains(songNameSpacesBefore));

        searchField.clear();
        String songNameSpacesAfter = "Reactor    ";
        searchField.sendKeys(songNameSpacesAfter);
        songNameSpacesAfter = songNameSpacesAfter.replaceAll("\\s", "");

        WebElement songsWithSpacesAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']")));
        String mySongsInSearchResults2 = songsWithSpacesAfter.getText();

        Assert.assertTrue(mySongsInSearchResults2.contains(songNameSpacesAfter));
    }

    @Test //issue INTERNSHIP-80424
    public void verifySearchFieldForCaseSensative_80404 () {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String songName = "Reactor";
        searchField.sendKeys(songName);
        //songName = songName.substring(0,1).toUpperCase() + songName.substring(1);

        WebElement songInSearchResults = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResults = songInSearchResults.getText();

        Assert.assertTrue(mySongsInSearchResults.contains(songName));

        searchField.clear();
        String songNameLowCase = songName.toLowerCase() ;
        searchField.sendKeys(songNameLowCase);

        WebElement songInSearchResultsLowCase = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResultsLowCase = songInSearchResultsLowCase.getText();

        //Assert.assertTrue(mySongsInSearchResultsLowCase.contains(songNameLowCase));
        Assert.assertEquals(mySongsInSearchResultsLowCase, "None found.");

        searchField.clear();
        String songNameUpperCase = songName.toLowerCase() ;
        searchField.sendKeys(songNameUpperCase);

        WebElement songInSearchResultsUpperCase = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResultsUpperCase = songInSearchResultsUpperCase.getText();

        //Assert.assertTrue(mySongsInSearchResultsUpperCase.contains(songNameLowCase));
        Assert.assertEquals(mySongsInSearchResultsUpperCase, "None found.");
    }

    @Test //issue INTERNSHIP-80425
    public void verifySearchAfterClearingByKeyboard_80405 () {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String songName = "Reactor";
        searchField.sendKeys(songName);

        WebElement songInSearchResults = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResults = songInSearchResults.getText();
        Assert.assertTrue(mySongsInSearchResults.contains(songName));


        searchField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        //WebElement emptySearch = driver.findElement(By.cssSelector("#searchExcerptsWrapper>.main-scroll-wrap"));
        WebElement emptySearch = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']"));
        String emptyPage = emptySearch.getText();
        String empty = "Find songs, artists, and albums";
        Assert.assertTrue(emptyPage.contains(empty));

        String urlSearch = "https://qa.koel.app/#!/search";
        Assert.assertEquals(driver.getCurrentUrl(), urlSearch);
    }

    @Test //issue INTERNSHIP-80426
    public void verifySearchAfterClearingByXButton_80406 (){
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String songName = "Reactor";
        searchField.sendKeys(songName);

        WebElement songInSearchResults = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResults = songInSearchResults.getText();

        Assert.assertTrue(mySongsInSearchResults.contains(songName));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchField).build().perform();

        WebElement xButton = driver.findElement(By.cssSelector("#searchForm > input"));
        xButton.click();

        //WebElement emptySearch = driver.findElement(By.cssSelector("#searchExcerptsWrapper>.main-scroll-wrap"));
        WebElement emptySearch = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']"));
        String emptyPage = emptySearch.getText();
        String empty = "Find songs, artists, and albums";
        Assert.assertTrue(emptyPage.contains(empty));

        String urlSearch = "https://qa.koel.app/#!/search";
        Assert.assertEquals(driver.getCurrentUrl(), urlSearch);
    }
}
