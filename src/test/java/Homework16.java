import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation(){
        // Pre-Conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // initializing Declaration and implicit wait
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        // Steps
        // Navigation - opens URL
        String url = "https://qa.koel.app/";
        driver.get(url);

        // Actions
        // - Element Search and element click
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();

        // Verifying redirected to registration page using Assertion, expected result
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.state(Boolean.parseBoolean(driver.getCurrentUrl()), registrationUrl);

        // close the browser
        driver.quit();














    }


}
