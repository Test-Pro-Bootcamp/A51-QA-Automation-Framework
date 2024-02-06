package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AlbumsPage extends BasePage {
    public AlbumsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (xpath = "//*[@id=\"albumsWrapper\"]/div/article")
    public List<WebElement> albumIcons;

    @FindBy (xpath = "//*[@id=\"albumsWrapper\"]/div/article[1]")
    public WebElement firstAlbumIcon;

    @FindBy (xpath = "//*[@id=\"albumsWrapper\"]/div/article[2]/span/span")
    public  WebElement albumCover;

    @FindBy (xpath = "//*[@id=\"albumsWrapper\"]/div/article[1]/footer/p/span[2]/a[1]/i")
    public WebElement shuffleIcon;

    @FindBy (xpath = "//*[@id=\"albumsWrapper\"]/div/article[1]/footer/p/span[2]/a[2]/i")
    public WebElement downloadIcon;

    public List<WebElement> getAllAlbumIcons() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(albumIcons));
    }

    public void hoverOverFirstAlbum(){
        wait.until(ExpectedConditions.visibilityOf(firstAlbumIcon));
        actions.moveToElement(firstAlbumIcon).perform();
    }

    public void hoverOverElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    /*
    public class ScrollUtils {

        public static void scrollToElement(WebDriver driver, WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }

        public static void scrollToBottom(WebDriver driver) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }
     */

}
