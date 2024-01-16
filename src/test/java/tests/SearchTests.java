package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTests extends BaseTest {
    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void verifySearchFromHomePage_80382(String email, String password) throws InterruptedException {
        loginIntoKoel(email, password);

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String songName = "Reactor";
        searchField.sendKeys(songName);

        Thread.sleep(2000);

        WebElement songInSearchResults = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResults = songInSearchResults.getText();

        Assert.assertTrue(mySongsInSearchResults.contains(songName));
    }

    @Test //issue INTERNSHIP-80407
    public void verifySearchBySongs_80389 () throws InterruptedException {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String searchName = "Pluto"; //song name
        searchField.sendKeys(searchName);

        Thread.sleep(2000);

        //verification for sons section
        WebElement resultsSongs = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String songsName = resultsSongs.getText();
        Assert.assertTrue(songsName.contains(searchName));

        searchField.clear();
        String searchName2 = "Unknown";
        searchField.sendKeys(searchName2);

        Thread.sleep(2000);

        //verification for artists section
        WebElement resultsArtists = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[2]"));
        String artistName = resultsArtists.getText();
        Assert.assertTrue(artistName.contains(searchName2));

        //verification for albums section
        WebElement resultsAlbums = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[3]"));
        //*[@id="searchExcerptsWrapper"]/div/div/section[3]/ul
        String albumName = resultsAlbums.getText();
        Assert.assertTrue(albumName.contains(searchName2));
    }

    @Test //issue INTERNSHIP-80407
    public void verifySearchByArtist_80393 () throws InterruptedException {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String searchName = "Xylo-Ziko"; //Artist name
        searchField.sendKeys(searchName);

        Thread.sleep(2000);

        //verification in artists section
        WebElement resultsArtists = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[2]"));
        String artistName = resultsArtists.getText();

        Assert.assertTrue(artistName.contains(searchName));
    }

    @Test //issue INTERNSHIP-80407
    public void verifySearchByAlbum_80395 () throws InterruptedException {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String searchName = "Prism"; //Album name
        searchField.sendKeys(searchName);

        Thread.sleep(2000);

        //verification in album section
        WebElement resultsAlbum = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[3]"));
        String albumName = resultsAlbum.getText();

        Assert.assertTrue(albumName.contains(searchName));
    }

    @Test //issue INTERNSHIP-80423
    public void verifySearchAfterInvalidData_80402 () throws InterruptedException {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String songName = "qwerty";
        searchField.sendKeys(songName);

        Thread.sleep(2000);

        WebElement noResultsSongs = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > p"));
        String noResultsSongsText = noResultsSongs.getText();
        //Assert.assertEquals(noResultsSongsText, "No results");
        Assert.assertEquals(noResultsSongsText, "None found.");

        WebElement noResultsArtists = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.artists > p"));
        String noResultsArtistsText = noResultsArtists.getText();
        //Assert.assertEquals(noResultsArtistsText, "No results");
        Assert.assertEquals(noResultsSongsText, "None found.");

        WebElement noResultsAlbums = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.albums > p"));
        String noResultsAlbumsText = noResultsAlbums.getText();
        //Assert.assertEquals(noResultsAlbumsText, "No results");
        Assert.assertEquals(noResultsSongsText, "None found.");
    }

    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void verifyIgnoringWhiteSpaces_80403(String email, String password) throws InterruptedException {
        loginIntoKoel(email, password);

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String songNameSpacesBefore = "    Reactor";
        searchField.sendKeys(songNameSpacesBefore);
        songNameSpacesBefore = songNameSpacesBefore.replaceAll("\\s", "");

        Thread.sleep(2000);

        WebElement songInSearchResults = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResults = songInSearchResults.getText();

        Assert.assertTrue(mySongsInSearchResults.contains(songNameSpacesBefore));

        searchField.clear();
        String songNameSpacesAfter = "Reactor    ";
        searchField.sendKeys(songNameSpacesAfter);
        songNameSpacesAfter = songNameSpacesAfter.replaceAll("\\s", "");
        Thread.sleep(2000);

        WebElement songsWithSpacesAfter = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResults2 = songsWithSpacesAfter.getText();

        Assert.assertTrue(mySongsInSearchResults2.contains(songNameSpacesAfter));
    }

    @Test //issue INTERNSHIP-80424
    public void verifySearchFieldForCaseSensative_80404 () throws InterruptedException {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String songName = "Reactor";
        searchField.sendKeys(songName);
        //songName = songName.substring(0,1).toUpperCase() + songName.substring(1);

        Thread.sleep(2000);

        WebElement songInSearchResults = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResults = songInSearchResults.getText();

        Assert.assertTrue(mySongsInSearchResults.contains(songName));

        searchField.clear();
        String songNameLowCase = songName.toLowerCase() ;
        searchField.sendKeys(songNameLowCase);
        Thread.sleep(2000);

        WebElement songInSearchResultsLowCase = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResultsLowCase = songInSearchResultsLowCase.getText();

        //Assert.assertTrue(mySongsInSearchResultsLowCase.contains(songNameLowCase));
        Assert.assertEquals(mySongsInSearchResultsLowCase, "None found.");

        searchField.clear();
        String songNameUpperCase = songName.toLowerCase() ;
        searchField.sendKeys(songNameUpperCase);
        Thread.sleep(2000);

        WebElement songInSearchResultsUpperCase = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResultsUpperCase = songInSearchResultsUpperCase.getText();

        //Assert.assertTrue(mySongsInSearchResultsUpperCase.contains(songNameLowCase));
        Assert.assertEquals(mySongsInSearchResultsUpperCase, "None found.");
    }

    @Test //issue INTERNSHIP-80425
    public void verifySearchAfterClearingByKeyboard_80405 () throws InterruptedException {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String songName = "Reactor";
        searchField.sendKeys(songName);
        Thread.sleep(2000);

        WebElement songInSearchResults = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResults = songInSearchResults.getText();

        Assert.assertTrue(mySongsInSearchResults.contains(songName));
        Thread.sleep(2000);

        searchField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        Thread.sleep(2000);

        //WebElement emptySearch = driver.findElement(By.cssSelector("#searchExcerptsWrapper>.main-scroll-wrap"));
        WebElement emptySearch = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']"));
        String emptyPage = emptySearch.getText();
        String empty = "Find songs, artists, and albums";
        Assert.assertTrue(emptyPage.contains(empty));

        String urlSearch = "https://qa.koel.app/#!/search";
        Assert.assertEquals(driver.getCurrentUrl(), urlSearch);
    }

    @Test //issue INTERNSHIP-80426
    public void verifySearchAfterClearingByXButton_80406 () throws InterruptedException {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String songName = "Reactor";
        searchField.sendKeys(songName);
        Thread.sleep(2000);

        WebElement songInSearchResults = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResults = songInSearchResults.getText();

        Assert.assertTrue(mySongsInSearchResults.contains(songName));
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        actions.moveToElement(searchField).build().perform();
        Thread.sleep(2000);
        WebElement xButton = driver.findElement(By.cssSelector("#searchForm > input"));
        xButton.click();
        Thread.sleep(2000);

        //WebElement emptySearch = driver.findElement(By.cssSelector("#searchExcerptsWrapper>.main-scroll-wrap"));
        WebElement emptySearch = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']"));
        String emptyPage = emptySearch.getText();
        String empty = "Find songs, artists, and albums";
        Assert.assertTrue(emptyPage.contains(empty));

        String urlSearch = "https://qa.koel.app/#!/search";
        Assert.assertEquals(driver.getCurrentUrl(), urlSearch);
    }
}
