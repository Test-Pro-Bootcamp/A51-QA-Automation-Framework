import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    /*
    TODO Homework #17: TestNG Overview
     *1. Create a new branch named homework-17.
     *2. Create a new file, Homework17.java in IntelliJ IDEA.
      3. Create a test case, addSongToPlaylist() using @Test annotation and the helper/reusable methods we created.
         *4. Navigate to "https://qa.koel.app/".
        * 5. Log in with your credentials.
         6. Search for a song (choose any song of your choice).
         7. Click 'View All' button to display the search results.
         8. Click the first song in the search results.
         9. Click 'ADD TO...' button.
         10. Choose the playlist to add it to, (you can create a new one with a unique name).
         11. Verify that a notification message appears and contains the text, "Added 1 song into {your playlist}".
         Note: For verification, please use the Assert.assertEquals() method to compare the actual notification message text with the expected text. If they match, the assertion will pass; otherwise, it will fail.
         12. Commit your changes to the new branch homework-17.
         13. Push your code to the remote repository.
         14. Create a pull request.
         Note: Your work will be auto graded so you can continue with the next assignment in less than a minute (just refresh the results page).
 */
    @Test
    public void addSongToPlaylist() throws InterruptedException{


        String uniquePlaylist = "HW17PL_"+ RandomString.make().substring(0,6);

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        //Creating Unique Playlist
        WebElement addPLBtn = driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        addPLBtn.click();
        Thread.sleep(3000);

        //Select New Playlist Option
        WebElement newPLBtn = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        newPLBtn.click();
        Thread.sleep(2000);

        //Enter new playlist name
         WebElement playListField = driver.findElement(By.cssSelector("input[name='name']"));
         playListField.clear();
         playListField.sendKeys(uniquePlaylist);//HW17PL
         Thread.sleep(2000);
         playListField.sendKeys(Keys.ENTER);
         Thread.sleep(2000);



        //TODO: Search for a song (choose any song of your choice).
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys("Dark Days");//Dark Days
        Thread.sleep(2000);

        //TODO: Click 'View All' button to display the search results.
        WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
        Thread.sleep(2000);


        //TODO: Click the first song in the search results.
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper table.items tr:nth-child(1)"));
        firstSong.click();
        Thread.sleep(2000);

        //TODO: Click 'ADD TO...' button.
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(3000);


        //TODO: Choose the playlist to add it to, (you can create a new one with a unique name).
        WebElement selectPL = driver.findElement(By.xpath("//section[@id='songResultsWrapper'] //li[contains( . , '"+uniquePlaylist+"')]"));
        selectPL.click();
        Thread.sleep(3000);


        //TODO: Verify that a notification message appears and contains the text, "Added 1 song into {your playlist}".
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.alertify-logs div.success"));//div.alertify-logs div.success
        uniquePlaylist = '"'+uniquePlaylist+"."+'"';
        String msgDisplayed = "Added 1 song into "+uniquePlaylist;

        Assert.assertEquals(msgDisplayed,notificationMsg.getText());

    }
}

