package stepDefinitions;

import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlayList;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
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


}
