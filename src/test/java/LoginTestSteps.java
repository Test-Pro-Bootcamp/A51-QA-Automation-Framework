import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class LoginTestSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void tearDouwn() {
        driver.quit();
    }

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    @When("I click on 'Log in'")
    public void clickOnLogin() {
        By submitBtn = By.cssSelector("button[type='submit']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn)).click();
    }

    @Then("page url was not changed")
    public void pageNotChanged() {
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
