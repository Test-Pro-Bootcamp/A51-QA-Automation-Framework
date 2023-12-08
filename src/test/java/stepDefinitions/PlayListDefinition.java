package stepDefinitions;

import Pages.PlayList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PlayListDefinition {
    WebDriver driver;

    @And("I search the song {string}")
    public void iSearchTheSong(String name) throws InterruptedException {
PlayList playList = new PlayList(driver);
playList.searchField(name);

    }

    @And("I click view all button")
    public void iClickViewAllButton() throws InterruptedException {
        PlayList playList = new PlayList(driver);
        playList.provideViewAll();
    }
    @And("I choose the song")
    public void iChooseTheSong() throws InterruptedException {
        PlayList playList = new PlayList(driver);
        playList.choiceSong();
    }

    @And("I add this song in the play list")
    public void iAddThisSongInThePlayList() throws InterruptedException {
        PlayList playList = new PlayList(driver);
        playList.addToList();
    }

    @And("I choose the play list")
    public void iChooseThePlayList() throws InterruptedException {
        PlayList playList = new PlayList(driver);
        playList.choiceList();
    }

    @Then("I see the notification Message about adding the song")
    public void iSeeTheNotificationMessageAboutAddingTheSong() {
        String expectedSongAddedMessage = "Added 1 song into \"dasha.\"";
        PlayList playList = new PlayList(driver);
        Assert.assertEquals(playList.notificationMessage(), expectedSongAddedMessage);
    }

}
