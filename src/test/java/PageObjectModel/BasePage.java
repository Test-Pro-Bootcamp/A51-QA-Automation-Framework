package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


//çonstructor for BasePage class

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    //Method to click on a web element
    protected void click(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
    //Method to find a web element
    protected WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    //protected void contextClick(WebElement webElement){
       // actions.contextClick(findElement(webElement)).perform();
   // }
   // protected void doubleClick(WebElement webElement){
        //actions.doubleClick(findElement(webElement)).perform();
    }


