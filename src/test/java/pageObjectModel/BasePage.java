package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected WebElement findElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void click(WebElement webElement) {
        findElement(webElement).click();
    }

    protected boolean waitForElementToBeNotVisible (WebElement webElement) {
        // Initialize a flag to track if the web element is not visible
        boolean isWebElementNotVisible = false;
        try {
            // Wait for the given web element to become invisible within 1 second
            isWebElementNotVisible = new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions
                    .invisibilityOf(webElement));
        } catch (TimeoutException e) {
            // If the element is still visible after waiting, set the flag to true
            isWebElementNotVisible = true;
        }
        // Return whether the web element is not visible
        return isWebElementNotVisible;
    }

    protected void doubleClick(WebElement webElement) {
        actions.doubleClick(findElement(webElement)).perform();
    }

    public Boolean isTextPresentInElement(WebElement webElement, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
            return true;  // Return true if the text is present
        } catch (TimeoutException e) {
            return false;  // Return false if the text is not present within the timeout
        }


//        protected List<WebElement> findElements (By locator) {
//        elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
//            return elements;
//        }
//        By locator = driver.findElements(By.xpath("//ol[@class=\"recently-added-album-list\"]//span[text()='by']"));

    }

}
