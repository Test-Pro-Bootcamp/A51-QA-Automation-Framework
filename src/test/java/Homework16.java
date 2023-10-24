import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework16 extends BaseTest {
    @Test
    public static void registrationNavigation() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Using Selenium, navigate to "https://qa.koel.app"
        String url = "https://qa.koel.app/";
        driver.get(url);

        // locate web element for the registration link
        // Click the Registration link
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();
        System.out.println("Did this work?");

        // Verify that you are redirected to the Registration page using the Assert method.
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

        driver.quit();
    }

}
