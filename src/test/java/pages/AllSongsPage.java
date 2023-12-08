package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage{

    public AllSongsPage (WebDriver givenDriver){
        super(givenDriver);
    }

    @FindBy(xpath="//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]")
    WebElement firstSong;

    @FindBy(xpath="//*[@id='app']/nav/ul/li[1]")
    WebElement playOption;

    @FindBy(css= "[data-testid='sound-bar-play']")
    WebElement soundBar;

    public AllSongsPage contextClickFirstSong(){
        contextClick(firstSong);
        return this;
    }

    public AllSongsPage clickPlaySoundTrack(){
        click(playOption);
        return this;

    }
   public boolean soundBarIcon(){
       return soundBar.isDisplayed();
   }




}

