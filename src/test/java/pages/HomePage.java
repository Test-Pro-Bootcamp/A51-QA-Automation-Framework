package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = "img.avatar")
    private WebElement avatar;
    //By userAvatarIcon = By.cssSelector("img.avatar");

    @FindBy (css = "[type='search']")
    private WebElement searchElement;

    @FindBy (css = ".songs")
    private WebElement allSongs;

    @FindBy (css = ".albums")
    private WebElement albums;

    public void clickAllSongs(){
        WebElement allSongsMenu = wait.until(ExpectedConditions.visibilityOf(allSongs));
        allSongsMenu.click();
    }

    public void clickAlbums(){
        WebElement albumsMenu = wait.until(ExpectedConditions.visibilityOf(albums));
        albumsMenu.click();
    }

    public WebElement getUserAvatar(){
        //WebElement userAvatar = driver.findElement(By.cssSelector("img.avatar"));
        //WebElement userAvatar =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        WebElement userAvatar =  wait.until(ExpectedConditions.visibilityOf(avatar));
        //return findElement((WebElement) userAvatarIcon);
        return userAvatar;
    }

    public void enterSongsName(String song){
        WebElement searchField = wait.until(ExpectedConditions.visibilityOf(searchElement));
        //WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        searchField.sendKeys(song);
    }




}
