import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.StringReader;


public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException{
        String expectedSongAddedMessage = "Added 1 song into \"Golden Girls Playlist.\"";

   //Open the URL on chrome browser for the webpage
   navigateToPage();

   //Fill in the email field on web page
   enterEmail("adam.johnson@testpro.io");

   //Fill in the password on the web page
   enterPassword("1Te$t$tudent");

   //Click the submit button
   clickSubmit();
    Thread.sleep(5000);
   //Search for a song
   searchSong("Reactor");
   clickViewAllBtn();
   selectFirstSongResult();
   clickAddToBtn();
   choosePlaylist();

   //Check for song
   Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);



    }



}
