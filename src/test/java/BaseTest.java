import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.security.Key;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    Duration TimeOut = Duration.ofSeconds(1);


    public String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    public void openBrowser(String siteUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver,TimeOut);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(siteUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"app\"]/div/div/form/div[1]/img")));

        //Assert.assertEquals(driver.getCurrentUrl(), siteUrl);
    }

    public void closeBrowser(){ driver.quit(); };
    public void loginSite(String useName, String pswd) {

        WebElement emUser = driver.findElement(By.cssSelector("[type='email']"));
        emUser.sendKeys(useName);

        WebElement emPswd = driver.findElement(By.cssSelector("[type='password']"));
        emPswd.sendKeys(pswd);

        WebElement emLogin = driver.findElement(By.cssSelector("[type='submit']"));
        emLogin.click();
        WebDriverWait wait = new WebDriverWait(driver,TimeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"userBadge\"]/a[1]/img")));

    }

    public void klSearch(String songName) {
        WebElement klSearch = driver.findElement(By.cssSelector("[type='search']"));
        klSearch.sendKeys("midnight");

        WebElement vAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        vAll.click();

        WebElement fList = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr"));
        fList.click();

        WebElement AddTo = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        AddTo.click();

        WebElement selPlaylist = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[12]"));
        selPlaylist.click();
    }

    public void playNextSong() {
        WebElement playNxt = driver.findElement((By.cssSelector("[title='Play next song")));
        playNxt.click();

    }

    public void playSongn() {
        WebElement playSng = driver.findElement((By.cssSelector("[title='Play or resume']")));
        playSng.click();

    }

    public void deleteSong(){
        WebDriverWait wait = new WebDriverWait(driver,TimeOut);
        if(confirmDelAval()){
            WebElement delSong = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
            //*[@id="playlistWrapper"]/header/div[3]/span/button[2]
            delSong.click();
            WebElement del = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
            del.click();
            //driver.findElement(By.xpath("/html/body/div[3]/div/div/nav/button[2]")).click();
        }
        else{
            driver.findElement(By.cssSelector("[title='Create a new playlist']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"playlists\"]/nav/ul/li[1]")));

            driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"playlists\"]/form/input")).sendKeys("Playlist2Delete");
            driver.findElement(By.xpath("//*[@id=\"playlists\"]/form/input")).submit();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"playlists\"]/ul/li[3]/a")));

            WebElement delSong = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
            delSong.click();
            WebElement del = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
            del.click();
            //driver.findElement(By.xpath("/html/body/div[3]/div/div/nav/button[2]")).click();
        }
    }

    public String renameKLPlaylist() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,TimeOut);

            Actions act = new Actions(driver);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
            //WebElement selPlayList = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
            WebElement selPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
            act.doubleClick(selPlayList).perform();
            WebElement slPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
            slPlayList.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
            slPlayList.sendKeys("Play1");
            slPlayList.sendKeys(Keys.ENTER);

            WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
            return confirm.getText();


    }
    public String GetSuccess(){
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }

    public boolean confirmPlay(){
        return !driver.findElements(By.cssSelector("[title='Pause']")).isEmpty();
    }

    public boolean confirmDelAval(){
        return !driver.findElements(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")).isEmpty();
    }

    public String getConfirmDelete(){
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }
}
