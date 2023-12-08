package stepDefinitions;

import Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomeStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void iOpenBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }


    @Given("I open login page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app/");
    }
    @And("I open Home Page")
    public void iOpenHomePage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @When("I choose All songs list")
    public void iChooseAllSongsList() {
        HomePage homePage = new HomePage(driver);
        homePage.chooseAllSongsList();
    }

    @And("I choose first song")
    public void iChooseFirstSong() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.contextClickFirstSong();
    }

    @And("I click play button")
    public void iClickPlayButton() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.choosePlayOption();
    }

    @Then("The song is playing")
    public void theSongIsPlaying() {
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }


    @And("I double click on the play list")
    public void iDoubleClickOnThePlayList() {
        PlayList playList = new PlayList(driver);
        playList.doubleClickPlaylist();
    }

    @And("I enter new play list name")
    public void iEnterNewPlayListName() {
        PlayList playList = new PlayList(driver);
        playList.enterNewPlaylistName();
    }

    @Then("The play list is renamed")
    public void thePlayListIsRenamed() {
        String updatePlaylistMsg = "Updated playlist \"new name for playlist.\"";
        PlayList playList = new PlayList(driver);
        Assert.assertEquals(playList.getRenamePlaylistSuccessMsg(),updatePlaylistMsg);
    }


    @And("I search the song {string}")
    public void iSearchTheSong(String name) {
        PlayList playList = new PlayList(driver);
        playList.searchField(name);
    }

    @And("I click view all button")
    public void iClickViewAllButton() {
        PlayList playList = new PlayList(driver);
        playList.provideViewAll();
    }

    @And("I choose the song")
    public void iChooseTheSong() {
        PlayList playList = new PlayList(driver);
        playList.choiceSong();
    }

    @And("I add this song in the play list")
    public void iAddThisSongInThePlayList() {
        PlayList playList = new PlayList(driver);
        playList.addToList();
    }

    @And("I choose the play list")
    public void iChooseThePlayList() {
        PlayList playList = new PlayList(driver);
        playList.choiceList();
    }

    @Then("I see the notification Message about adding the song")
    public void iSeeTheNotificationMessageAboutAddingTheSong() {
        String expectedSongAddedMessage = "Added 1 song into \"new name for playlist.\"";
        PlayList playList = new PlayList(driver);
        Assert.assertEquals(playList.notificationMessage(), expectedSongAddedMessage);
    }
}
