package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();


    }

    public void contextClick(WebElement webElement){
        actions.contextClick(findElement(webElement)).perform();

    }

    public WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
