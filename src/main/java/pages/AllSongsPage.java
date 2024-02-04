package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class AllSongsPage extends BasePage{
    @FindAll({
            @FindBy(css = "td.artist"),
            @FindBy(css = "td.title"),
            @FindBy(css = "td.album"),
            @FindBy(css = "td.time.text-secondary")
    })
    private List<WebElement> columns;
    @FindBy(css = "#songsWrapper table.items tr.song-item")
    private List<WebElement> tableRows;
    @FindBy(xpath = "//section[@id='songsWrapper']//tr[@class='song-item']//button[@class='text-secondary' and contains(@title, 'Like')]")
    private WebElement singleLikeButton;
    @FindBy(xpath = "//section[@id='songsWrapper']//tr[@class='song-item']//button[@class='text-secondary' and contains(@title, 'Unlike')]")
    private List<WebElement> likedSongsButton;
    @FindBy(css = "#songsWrapper span.meta.text-secondary span")
    private WebElement headerTotalDurationText;
    private final String durationRe = "[^\\W•]+([1-9][0-99]+|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])";
    private final String songTotalRe = "^\\d{1,}[^\\W•]";

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean findSongInfo() {
        for(WebElement el: columns) {
            return (!el.getText().isEmpty());
        }
        return false;
    }
    public int getTotalSongsCount() {
        System.out.println(tableRows.size());
        return tableRows.size();
    }
    public String duration() {
        return findElement(headerTotalDurationText).getText();
    }

    private boolean checkTotalOrDuration(String regex, String time) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(time);
        return matcher.find();
    }
   private String extractTotalOrDuration(String regex, String time) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(time);
        if (matcher.find()) {
            Reporter.log("extracted" + matcher.group(), true);
            return matcher.group();
        } else {
            Reporter.log("Did not find correctly formatted  duration", true);
            return null;
        }
    }
   public boolean songTotalIsDisplayed() {
        return checkTotalOrDuration(durationRe, duration());
   }
   public boolean totalDurationIsDisplayed() {
        return checkTotalOrDuration(songTotalRe, duration());
   }
   public String getSongTotalFromHeader() {
        return extractTotalOrDuration(songTotalRe, duration());
   }
   public String getDurationFromHeader() {
        return extractTotalOrDuration(durationRe, duration());
   }

}
