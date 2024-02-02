package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllSongsPage extends BasePage {
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(tagName = "tr")
    private List<WebElement> songsInList;

    @FindBy(css = "#songsWrapper > header > div.heading-wrapper > span > span")
    private WebElement songsQuantity;

    public int countSongs() {
        System.out.println("Number of songs: " + songsInList.size());
        return songsInList.size();
    }


    public String calculateTotalDuration() {
        int totalDurationInSeconds = 0;

        for (WebElement songInAllSongsList : songsInList) {
            String songInfo = songInAllSongsList.getText();
            String durationString = extractDuration(songInfo);
            int durationInSeconds = convertDurationToSeconds(durationString);
            //System.out.println("Duration of song: " + durationString);

            totalDurationInSeconds += durationInSeconds;
        }
        //System.out.println("Calculated Total Duration of all songs in seconds: " + totalDurationInSeconds);
        System.out.println("Calculated Total Duration of all songs: " + formatDuration(totalDurationInSeconds));
        return formatDuration(totalDurationInSeconds);
    }

    private String extractDuration(String songInfo) {
        // Assuming the duration is in the format MM:SS
        String[] parts = songInfo.split(" ");
        return parts[parts.length - 1];
    }

    public String visibleQuantityOfSongsAndDuration() {
        System.out.println("Visible number and duration of all songs: " + songsQuantity.getText());
        return songsQuantity.getText();
    }

    private int convertDurationToSeconds(String durationString) {
        try {
            String[] timeParts = durationString.split(":");
            int minutes = Integer.parseInt(timeParts[0]);
            int seconds = Integer.parseInt(timeParts[1]);
            return minutes * 60 + seconds;
        } catch (NumberFormatException e) {
            // Handle the case where parsing fails (e.g., if the duration string is not in the expected format)
            System.err.println("Error parsing duration: " + durationString);
            return 0; // or throw an exception, depending on how you want to handle it
        }
    }


    public String formatDuration(int totalDurationInSeconds) {
        int hours = totalDurationInSeconds / 3600;
        int minutes = (totalDurationInSeconds - (hours * 3600)) / 60;
        int seconds = totalDurationInSeconds - (hours * 3600 + minutes * 60);
        return String.format("0%d:%02d:%02d", hours, minutes, seconds);
    }


    public int parseVisibleQuantityOfSongs(String input) {
        // Define a regex pattern to match the first numeric part
        Pattern pattern = Pattern.compile("\\b\\d+\\b");

        // Create a matcher with the input string
        Matcher matcher = pattern.matcher(input);

        // Check if the pattern is found
        if (matcher.find()) {
            // Extract the first numeric part and convert it to an integer
            String numericPart = matcher.group();
            System.out.println("Extract the first numeric part and convert it to an integer: " + Integer.parseInt(numericPart));
            return Integer.parseInt(numericPart);
        } else {
            // If no match is found, return a default value or throw an exception
            throw new RuntimeException("No match found for the first number");
        }
    }

    public String parseVisibleDurationOfSongs(String input) {
        String timeString = input.split(" • ")[1];

// Convert time to seconds
        String[] timeComponents = timeString.split(":");
        int hours = Integer.parseInt(timeComponents[0]);
        int minutes = Integer.parseInt(timeComponents[1]);
        int seconds = Integer.parseInt(timeComponents[2]);

        //int totalSeconds = hours * 3600 + minutes * 60 + seconds;

        //System.out.println("Total seconds: " + totalSeconds);
        //return totalSeconds;
        System.out.println("Visible Total Duration of all songs: " + String.format("0%d:%02d:%02d", hours, minutes, seconds));
        return String.format("0%d:%02d:%02d", hours, minutes, seconds);
    }



}
