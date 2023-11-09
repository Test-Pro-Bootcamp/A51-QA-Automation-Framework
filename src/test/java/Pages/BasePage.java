package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Actions action;

    public BasePage(WebDriver dr){
        driver = dr;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void click (WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public void doubleClick(WebElement webElement){
        action.doubleClick(findElement(webElement)).perform();
    }
    //@BeforeSuite
    //static void setupClass() {
      //  WebDriverManager.chromedriver().setup();
    //}
}