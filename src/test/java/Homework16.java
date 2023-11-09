import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() throws InterruptedException{

        //Pre-condition
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();

        Thread.sleep(2000);//Sleep or pause for 2 seconds (adjust as needed)

        //ExpectedResult
        
        //Method 1
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(),registrationUrl);//https://qa.koel.app/registration

        //Method 2
        // WebElement header2 = driver.findElement(By.tagName("h2"));
        //Assert.assertTrue(header2.isDisplayed());

        //Post-condition
        driver.quit();
    }
}
