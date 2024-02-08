package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class SmartPlaylistPage extends BasePage {
    public SmartPlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public String smartPlaylistName = "SmartPlaylist";

    String ruleInput = "Frantic";

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[1]/input")
    public WebElement nameInputField;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//div[2]/div/div[2]/select[1]")
    public WebElement firstDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[1]")
    public WebElement firstOptionFirstDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]/option")
    public List<WebElement> listFirstDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[2]/select[2]")
    public WebElement secondDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[2]/select[2]/option[1]")
    public WebElement firstOptionSecondDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[2]/select[2]/option")
    public List<WebElement> listSecondDropDown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[2]/span/input")
    public WebElement ruleInputField;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/footer/button[1]")
    public WebElement saveButton;

    @FindBy (css = "div.success.show")
    public WebElement notificationMessage;

    @FindBy (xpath = "//*[@id=\"playlistWrapper\"]/header/div[2]/h1")
    public WebElement createdSmartPlaylist;

    public void provideNameForSmartPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(nameInputField));
        nameInputField.clear();
        nameInputField.click();
        nameInputField.sendKeys(smartPlaylistName);
    }

    public void selectFirstDropdown(){
        wait.until(ExpectedConditions.visibilityOf(firstDropdown));
        firstDropdown.click();
        firstOptionFirstDropdown.click();
    }

    public void selectSecondDropdown(){
        wait.until(ExpectedConditions.visibilityOf(secondDropdown));
        secondDropdown.click();
        firstOptionSecondDropdown.click();
    }


    public void provideRuleInputField(){
        wait.until(ExpectedConditions.elementToBeClickable(ruleInputField));
        ruleInputField.click();
        ruleInputField.clear();
        ruleInputField.sendKeys(ruleInput);
    }

    public void clickSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public String verifyNotificationMessage() {
        wait.until(ExpectedConditions.visibilityOf(notificationMessage));
        return notificationMessage.getText();
    }

    public void selectFirstDropdownRandomly(){
        wait.until(ExpectedConditions.visibilityOf(firstDropdown));
        firstDropdown.click();
        Random rand = new Random();
        int randomIndex = rand.nextInt(listFirstDropdown.size());
        listFirstDropdown.get(randomIndex).click();
    }

    public void selectSecondDropdownRandomly(){
        wait.until(ExpectedConditions.visibilityOf(secondDropdown));
        secondDropdown.click();
        Random rand = new Random();
        int randomIndex = rand.nextInt(listSecondDropDown.size());
        listSecondDropDown.get(randomIndex).click();
    }


}
