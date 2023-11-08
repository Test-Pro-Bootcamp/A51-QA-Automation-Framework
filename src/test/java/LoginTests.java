
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import java.time.Duration;

public class LoginTests extends BaseTest {
    ChromeOptions options = new ChromeOptions();

    @Test
    public void loginValidEmailPassword(){
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        options.addArguments("--remote-allow-origins=*");
        /**
         * *this is a change
         */

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Steps
        String url = "https://qa.koel.app/";

        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");



            WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            submit.click();
            navigateToLoginPage();
            provideEmail("invalid@class.com");
            providePassword("te$t$tudent");
            clickSubmit();

            WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
            // Expected Result
            Assert.assertTrue(avatarIcon.isDisplayed());

            driver.quit();
            Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
        }

        @Test
        public void loginInvalidEmailValidPassword() throws InterruptedException {
            // Pre-condition
            // Added ChromeOptions argument below to fix websocket error
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://qa.koel.app/";
            driver.get(url);

            // Steps
            WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
            emailField.clear();
            emailField.sendKeys("invalid@class.com");

            WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
            passwordField.clear();
            passwordField.sendKeys("te$t$tudent");

            WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            submit.click();

            Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
            // Expected Result
            Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/

                // Post-condition
                driver.quit();
                navigateToLoginPage();
                provideEmail("demo@class.com");
                providePassword("te$t$tudent");
                clickSubmit();
                isAvatarDisplayed();
            }

            @Test
            public void loginValidEmailEmptyPassword() throws InterruptedException {
                // Pre-condition
                // Added ChromeOptions argument below to fix websocket error
                options.addArguments("--remote-allow-origins=*");

                WebDriver driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


                    // Steps
                    String url = "https://qa.koel.app";
                    driver.get(url);
                    navigateToLoginPage();
                    provideEmail("zhanna.ivanova@testpro.io");
                    providePassword("12345678");
                    clickSubmit();

                    WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
                    emailField.clear();
                    emailField.sendKeys("demo@class.com");

                    WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
                    submit.click();


                    Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
                    // Expected Result
                    Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/

                    // Post-condition
                    driver.quit();
                }

            }

