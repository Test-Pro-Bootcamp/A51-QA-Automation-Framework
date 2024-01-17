package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SearchTests extends BaseTest {
    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void verifySearchFromHomePage_80382(String email, String password) {
        loginIntoKoel(email, password);

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        //WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String songName = "Reactor";
        searchField.sendKeys(songName);

        WebElement songInSearchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']")));
        //WebElement songInSearchResults = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String mySongsInSearchResults = songInSearchResults.getText();

        Assert.assertTrue(mySongsInSearchResults.contains(songName));
    }

    @Test //issue INTERNSHIP-80407
    public void verifySearchBySongs_80389 () {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        //WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String searchName = "Pluto"; //song name
        searchField.sendKeys(searchName);

        //verification in songs section
        WebElement resultsSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']")));
        //WebElement resultsSongs = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']//span[@class='main']/span[@class='details']"));
        String songsName = resultsSongs.getText();
        Assert.assertTrue(songsName.contains(searchName));

        /*
        searchField.clear();
        String searchName2 = "Unknown"; //Artist name
        searchField.sendKeys(searchName2);

        //verification in artists section
        WebElement resultsArtists = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[2]")));
        //WebElement resultsArtists = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[2]"));
        String artistName = resultsArtists.getText();
        Assert.assertTrue(artistName.contains(searchName2));

        searchField.clear();
        String searchName3 = "Unknown";
        searchField.sendKeys(searchName3);
        //verification in albums section
        WebElement resultsAlbums = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[3]")));
        //WebElement resultsAlbums = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[3]"));
        String albumName = resultsAlbums.getText();
        Assert.assertTrue(albumName.contains(searchName3));*/
    }

    @Test //issue INTERNSHIP-80407
    public void verifySearchByArtist_80393 () {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String searchName = "Xylo-Ziko"; //Artist name
        searchField.sendKeys(searchName);

        //verification in artists section
        WebElement resultsArtists = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[2]"));
        String artistName = resultsArtists.getText();

        Assert.assertTrue(artistName.contains(searchName));
    }

    @Test //issue INTERNSHIP-80407
    public void verifySearchByAlbum_80395 () {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        String searchName = "Prism"; //Album name
        searchField.sendKeys(searchName);

        //verification in album section
        WebElement resultsAlbum = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[3]"));
        String albumName = resultsAlbum.getText();

        Assert.assertTrue(albumName.contains(searchName));
    }

    @Test //issue INTERNSHIP-80423
    public void verifySearchAfterInvalidData_80402 () {
        loginIntoKoel("alina.nikolaienko@testpro.io", "OPJKDUhA");

        WebElement searchField;
        searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchField.clear();
        String songName = "qwerty";
        searchField.sendKeys(songName);

        WebElement noResultsSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > p")));
        //WebElement noResultsSongs = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > p"));
        String noResultsSongsText = noResultsSongs.getText();
        //Assert.assertEquals(noResultsSongsText, "No results");
        Assert.assertEquals(noResultsSongsText, "None found.");

        WebElement noResultsArtists = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchExcerptsWrapper > div > div > section.artists > p")));
        //WebElement noResultsArtists = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.artists > p"));
        String noResultsArtistsText = noResultsArtists.getText();
        //Assert.assertEquals(noResultsArtistsText, "No results");
        Assert.assertEquals(noResultsSongsText, "None found.");

        WebElement noResultsAlbums = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchExcerptsWrapper > div > div > section.albums > p")));
        //WebElement noResultsAlbums = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.albums > p"));
        String noResultsAlbumsText = noResultsAlbums.getText();
        //Assert.assertEquals(noResultsAlbumsText, "No results");
        Assert.assertEquals(noResultsSongsText, "None found.");
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
