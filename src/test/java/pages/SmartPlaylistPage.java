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

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[1]/input")
    public WebElement nameInputField;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//div[2]/div/div[2]/select[1]")
    public WebElement firstDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[1]")
    public WebElement firstRuleFirstDropdownOption;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div/div[2]/select[1]/option")
    public List<WebElement> listFirstDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[2]/select[2]")
    public WebElement secondDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[2]/select[2]/option[3]")
    public WebElement firstRuleSecondDropdownOption;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[2]/select[2]/option")
    public List<WebElement> listSecondDropDown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[2]/span/input")
    public WebElement ruleInputField;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[3]/select[1]")
    public WebElement secondRuleFirstDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[3]/select[2]")
    public WebElement secondRuleSecondDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[3]/select[1]/option[3]")
    public WebElement secondRuleFirstDropdownOption;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[3]/select[2]/option[3]")
    public WebElement secondRuleSecondDropdownOption;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/div[3]/span/input")
    public WebElement secondRuleInputField;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/button")
    public WebElement addGroupButton;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div[2]/div[2]/select[1]")
    public WebElement groupFirstDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div[2]/div[2]/select[1]/option[3]")
    public WebElement groupFirstDropdownOption;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div[2]/div[2]/select[2]")
    public WebElement groupSecondDropdown;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div[2]/div[2]/select[2]/option[3]")
    public WebElement groupSecondDropdownOption;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div[2]/div[2]/span/input")
    public WebElement groupInputField;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/footer/button[1]")
    public WebElement saveButton;

    @FindBy (css = "div.success.show")
    public WebElement notificationMessage;

    @FindBy (xpath = "//*[@id=\"playlistWrapper\"]/header/div[2]/h1")
    public WebElement createdSmartPlaylist;

    @FindBy (xpath = "//*[@id=\"playlistWrapper\"]/div/div/div")
    public WebElement emptyPageMessage;

    @FindBy (xpath = "//*[@id=\"mainWrapper\"]//form/div/div[2]/div/button")
    public WebElement addRuleButton;

    public void provideNameForSmartPlaylist(String smartPlaylistName ){
        wait.until(ExpectedConditions.elementToBeClickable(nameInputField));
        nameInputField.clear();
        nameInputField.click();
        nameInputField.sendKeys(smartPlaylistName);
    }

    public void selectFirstDropdown(){
        wait.until(ExpectedConditions.visibilityOf(firstDropdown));
        firstDropdown.click();
        firstRuleFirstDropdownOption.click();
    }

    public void selectSecondDropdown(){
        wait.until(ExpectedConditions.visibilityOf(secondDropdown));
        secondDropdown.click();
        firstRuleSecondDropdownOption.click();
    }


    public void provideRuleInputField(String ruleInput){
        wait.until(ExpectedConditions.elementToBeClickable(ruleInputField));
        ruleInputField.click();
        ruleInputField.clear();
        ruleInputField.sendKeys(ruleInput);
    }

    public void provideFirstRule(String ruleInput){
        selectFirstDropdown();
        firstRuleFirstDropdownOption.click();
        selectSecondDropdown();
        firstRuleSecondDropdownOption.click();
        provideRuleInputField(ruleInput);
    }

    public void provideSecondRule(String ruleSecondInput){
        secondRuleFirstDropdown.click();
        secondRuleFirstDropdownOption.click();

        secondRuleSecondDropdown.click();
        secondRuleSecondDropdownOption.click();

        secondRuleInputField.click();
        secondRuleInputField.clear();
        secondRuleInputField.sendKeys(ruleSecondInput);
    }

    public void clickAddRuleButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addRuleButton));
        addRuleButton.click();
    }

    public void clickAddGroupButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addGroupButton));
        addGroupButton.click();
    }

    public void provideGroup(String groupInput){
        groupFirstDropdown.click();
        groupFirstDropdownOption.click();
        groupSecondDropdown.click();
        groupSecondDropdownOption.click();

        groupInputField.click();
        groupInputField.clear();
        groupInputField.sendKeys(groupInput);
    }

    public void clickSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public String getTextMessage() {
        wait.until(ExpectedConditions.visibilityOf(emptyPageMessage));
        return emptyPageMessage.getText();
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
