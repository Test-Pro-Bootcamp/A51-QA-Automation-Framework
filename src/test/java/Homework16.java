import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {

@Test
public void registrationNavigation() {

    //Pre-Conditions
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-all-origins=*");

    WebDriver driver = new ChromeDiver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //Steps
    String url = "https://qa.koel.app";
    driver.get(url);

    //Actions
    //Step 1
    WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
    //Step 2
    registrationLink.click();
    //Step 3
    Assert.assertEquals(driver.getCurrentUrl(), url);
    //Step 4
    driver.quit();

}

}