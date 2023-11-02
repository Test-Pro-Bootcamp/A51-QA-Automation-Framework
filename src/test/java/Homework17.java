import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    /**
     * Test case to add a song to a playlist
     * @throws InterruptedException
     */
    @Test
    public void addSongToPlaylist() throws InterruptedException{

        String uniquePlaylist = generateNewPlaylistName();

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        //Creating Unique Playlist
        clickSideBarCreatePlaylistBtn();

        Thread.sleep(2000);

        //Select New Playlist Option
        clickMenuOptionNewPlaylist();

        Thread.sleep(2000);

        //Enter new playlist name
        provideNewPlaylistName(uniquePlaylist);

        Thread.sleep(2000);

        provideSongNameForSearch();

        Thread.sleep(2000);

        clickSearchResultsViewAllBtn();

        Thread.sleep(2000);

        clickSearchResultsFirstSong();

        Thread.sleep(2000);

        clickSelectedSongAddToBtn();

        Thread.sleep(2000);

        clickOnPlaylistNameFromAddToMenu(uniquePlaylist);

        Thread.sleep(3000);


        //Expected Results
        String updatedUniquePlaylist = updateUniquePlaylistString(uniquePlaylist);
        String msgDisplayed = createValidNotificationMessageString(updatedUniquePlaylist);

        WebElement notificationMsg = driver.findElement(By.cssSelector("div.alertify-logs div.success"));//div.alertify-logs div.success

        Assert.assertEquals(msgDisplayed,notificationMsg.getText());

    }

    /**
     * Adds quotations marks and period to the uniquePlaylist String provided
     * @param uniquePlaylist the original playlist name that should be modified.
     * @return a String with provided playlist name concatenated to quotation marks and a period.
     */
    private String updateUniquePlaylistString(String uniquePlaylist) {
        return '"'+uniquePlaylist+"."+'"';
    }

    /**
     * Finds the element list item that contains the new playlist added and clicks on the item.
     * @param uniquePlaylist Name of the new playlist created
     */
    private void clickOnPlaylistNameFromAddToMenu(String uniquePlaylist) {
        WebElement selectPL = driver.findElement(By.xpath("//section[@id='songResultsWrapper'] //li[contains( . , '"+uniquePlaylist+"')]"));
        selectPL.click();
    }

    /**
     *  Finds the element of the Add To button that appears when a song from the search results list is clicked on
     *  and clicks on the button.
    **/
    private void clickSelectedSongAddToBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
    }

    /**
     * Finds the first song from the search results list and clicks on it.
     */
    private void clickSearchResultsFirstSong() {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper table.items tr:nth-child(1)"));
        firstSong.click();
    }

    /**
     * Finds the View All button from the search results list view and clicks on it.
     */
    private void clickSearchResultsViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    /**
     * Finds the search textbox field and enters the song to search for. Once song is entered
     * the search begins and results are displayed.
     */
    private void provideSongNameForSearch() {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys("Dark Days");//Dark Days
    }

    /**
     * Find the input textbox to enter the new playlist name on the left side menu. The textbox appears when the "+" is clicked
     * and the options "New Playlist" is selected.
     * @param uniquePlaylist is the name of the new playlist that will be created and entered into the textbox.
     */
    private void provideNewPlaylistName(String uniquePlaylist) {
        WebElement playListField = driver.findElement(By.cssSelector("input[name='name']"));
        playListField.clear();
        playListField.sendKeys(uniquePlaylist);
        playListField.sendKeys(Keys.ENTER);
    }

    /**
     * Finds the element for the new playlist option from the menu that appears in the leftside menu
     * when the "+" is clicked and clicks on the element.
     */
    private void clickMenuOptionNewPlaylist() {
        WebElement newPLBtn = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        newPLBtn.click();
    }

    /**
     * Finds the element for the "+" button from the left side menu and clicks on it to add a new playlist.
     */
    private void clickSideBarCreatePlaylistBtn() {
        WebElement addPLBtn = driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        addPLBtn.click();
    }

    /**
     * Creates a random string and concatenates it to a base playlist name to generate a unique playlist name.
     * @return the new uniquie playlist name String
     */
    private String generateNewPlaylistName() {
        return "HW17PL_"+ RandomString.make().substring(0,6);
    }

    /**
     * Creates the expected result valid notification message string.
     * @param updatedUniquePlaylist the unique playlist name updated with the quotation marks and period.
     * @return the full valid notification message string created.
     */
    private String createValidNotificationMessageString(String updatedUniquePlaylist){
        return "Added 1 song into "+updatedUniquePlaylist;
    }

}

