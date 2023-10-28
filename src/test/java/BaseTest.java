import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.Message;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    public void openBrowser(String siteUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(siteUrl);

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

    public String GetSuccess(){
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }
}