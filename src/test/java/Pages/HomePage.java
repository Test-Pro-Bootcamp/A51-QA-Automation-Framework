package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);

    }
        //Locators
        By selectPlaylist = By.xpath("//a[@href='#!/playlist/78934']");

        By clickEdit = By.xpath("//li[@data-testid='playlist-context-menu-edit-78934']");

        By playlistNameField = By.xpath("//input[@name='name']");

        By displayedRenameSuccessMsg = By.cssSelector("div.success.show");

        //Actions

        public void clickPlaylist() {
            contextClick(selectPlaylist);
        }
        public void edit() {
            click(clickEdit);
        }
        public void editPlaylistName(String playlistName) {
            findElement(playlistNameField).sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
            findElement(playlistNameField).sendKeys(playlistName);
            findElement(playlistNameField).sendKeys(Keys.ENTER);
        }
        public String getRenameSuccessMsg() {
            return findElement (displayedRenameSuccessMsg).getText();
        }




    }


