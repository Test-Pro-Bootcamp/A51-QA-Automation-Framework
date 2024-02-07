package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllSongsPage extends BasePage {
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(tagName = "tr")
    public List<WebElement> songsInList;

    @FindBy(xpath = "//*[@id=\"songsWrapper\"]/header/div[2]/span/span")
    public WebElement songsQuantity;

    @FindBy (css = "#songsWrapper > header > div.song-list-controls > span > button.btn-add-to")
    public WebElement addToButton;

    @FindBy (xpath = "//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[contains(text(), 'Playlist')]")
    public WebElement playlistForAddingSongs;

    @FindBy (css = "div.success.show")
    WebElement notificationMessage;

    public int countSongs() {
        //System.out.println("Calculated quantity of songs: " + songsInList.size());
        return songsInList.size();
    }

    public String visibleQuantityOfSongsAndDuration() {
        return songsQuantity.getText();
    }

    public int extractVisibleQuantityOfAllSongs(String input) {
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String numericPart = matcher.group();
            System.out.println("Visible quantity of songs: " + Integer.parseInt(numericPart));
            return Integer.parseInt(numericPart);
        } else {
            throw new RuntimeException("No match found for the first number");
        }
    }

    public String extractVisibleDurationOfAllSongs(String input) {
        //66 songs • 04:32:57
        String timeString = input.split(" • ")[1];
        String[] timeComponents = timeString.split(":");
        int hours = Integer.parseInt(timeComponents[0]);
        int minutes = Integer.parseInt(timeComponents[1]);
        int seconds = Integer.parseInt(timeComponents[2]);
        return String.format("0%d:%02d:%02d", hours, minutes, seconds);
    }

    public String calculateTotalDurationOfAllSongs() {
        int totalDurationInSeconds = 0;

        for (WebElement songInAllSongsList : songsInList) {
            String songInfo = songInAllSongsList.getText();
            String durationString = extractDurationOfSong(songInfo);
            int durationInSeconds = convertDurationToSeconds(durationString);
            totalDurationInSeconds += durationInSeconds;
        }
        return formatDuration(totalDurationInSeconds);
    }

    private String extractDurationOfSong(String songInfo) {
        String[] parts = songInfo.split(" ");
        return parts[parts.length - 1];
    }

    private int convertDurationToSeconds(String durationString) {
        try {
            String[] timeParts = durationString.split(":");
            int minutes = Integer.parseInt(timeParts[0]);
            int seconds = Integer.parseInt(timeParts[1]);
            return minutes * 60 + seconds;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String formatDuration(int totalDurationInSeconds) {
        int hours = totalDurationInSeconds / 3600;
        int minutes = (totalDurationInSeconds - (hours * 3600)) / 60;
        int seconds = totalDurationInSeconds - (hours * 3600 + minutes * 60);
        return String.format("0%d:%02d:%02d", hours, minutes, seconds);
    }


    public void addSongToPlaylist() {
        //wait.until(ExpectedConditions.visibilityOf(listButton));
        Actions action = new Actions(driver);
        action.moveToElement(playlistForAddingSongs);
        playlistForAddingSongs.click();
    }

    public String verifyNotificationMessage() {
        wait.until(ExpectedConditions.visibilityOf(notificationMessage));
        return notificationMessage.getText();
    }


}
