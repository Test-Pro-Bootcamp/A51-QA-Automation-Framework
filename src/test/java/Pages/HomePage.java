package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page Factory

    @FindBy(css = "input[type='search']")
    WebElement field;
    @FindBy(css = "button[data-test='view-all-songs-btn']")
    WebElement viewAll;
    @FindBy(xpath = "//section[@id='songResultsWrapper']//tr[@class]")
    WebElement song;
    @FindBy(css = "button[class='btn-add-to']")
    WebElement buttonAdd;
    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[contains(text(), 'dasha')]")
    WebElement list;
    @FindBy(css = "div.success.show")
    WebElement message;


    public HomePage searchField(String name){
        field.clear();
        field.sendKeys(name);

        return this;

    }

    public HomePage provideViewAll(){
        viewAll.click();
        return this;
    }

    public HomePage choiceSong(){
        song.click();
        return this;
    }

    public HomePage addToList(){
        buttonAdd.click();
        return this;
    }

    public HomePage choiceList(){
        list.click();
        return this;
    }
    public String notificationMessage(){
        return message.getText();
    }
}