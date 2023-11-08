import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{

    //Prerequisite - empty playlist to delete

    @Test
    public void deletePlaylist(){
        String expectedPLayListDeletedMessage = "Deleted playlist \"Golden Girls.\"";

        provideEmail("adam.johnson@testpro.io");
        providePassword("1Te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPLayListDeletedMessage);
    }




}
