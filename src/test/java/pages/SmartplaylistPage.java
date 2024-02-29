package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SmartplaylistPage extends BasePage {

    public SmartplaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    String plylistName = "melodious Album";

    String ruleInput = "S";
    @FindBy(css="[name='name']")
    static WebElement smartPlaylistNameField;

    @FindBy(css="[data-test='smart-playlist-rule-group']")
    WebElement firstRule;

    @FindBy (css="[name='model[]']")
    WebElement firstRuleFirstDropdown;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[2]/select[2]")
    WebElement firstRuleSecondDropdown;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[1]")
    WebElement getFirstRuleFirstDropdownInput;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[2]/select[2]/option[5]")
    WebElement getFirstRuleSecondDropdownInput;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[3]")
    WebElement getFirstFieldThirdDropdownInput;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[4]")
    WebElement getFirstFieldFourthDropdownInput;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[2]/select[1]/option[5]")
    WebElement getFirstFieldFifthDropdownInput;


    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[2]/select[2]/option[1]")
    WebElement getSecondFieldFirstDropdownInput;


    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[2]/select[2]/option[2]")
    WebElement getSecondFieldSecondDropdownInput;

    @FindBy(css="[name='value[]']")
    WebElement thirdFieldInput;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/button")
    WebElement addRule;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[3]/select[1]")
    WebElement secondRuleFirstDropdownField;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[3]/select[1]/option[3]")
    WebElement secondRuleFirstDropdownFieldOption;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[3]/select[2]")
    WebElement secondRuleSecondDropdownField;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[3]/select[2]/option[1]")
    WebElement secondRuleSecondDropdownFieldOption;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div/div[3]/span/input")
    WebElement secondRuleThirdInputField;

    @FindBy(xpath="//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/button")
    WebElement addGroup;

    @FindBy(xpath="//*[@id=\"mainWrapper\"]/div/div/div/form/div/div[2]/div[2]/div[2]/select[1]")
    WebElement groupFirstDropdownField;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div[2]/div[2]/select[1]/option[2]")
    WebElement groupFirstDropdownFieldOption;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div[2]/div[2]/select[2]")
    WebElement groupSecondDropdownField;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div[2]/div[2]/select[2]/option[5]")
    WebElement groupSecondDropdownFieldOption;

    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/div/div[2]/div[2]/div[2]/span/input")
    WebElement groupThirdFieldInput;
    @FindBy(xpath="//*[@id='mainWrapper']/div/div/div/form/footer/button[1]")
    WebElement save;

    @FindBy(xpath="//*[@id='playlistWrapper']/div/div/div")
    WebElement emptyPlaylistMsg;
    public SmartplaylistPage enterSmartPlaylistName(String playlistName) {
        findElement(smartPlaylistNameField);
        smartPlaylistNameField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        smartPlaylistNameField.sendKeys(playlistName);
        //smartPlaylistNameField.sendKeys(Keys.ENTER);
        return this;
    }

    public  SmartplaylistPage selectFirstDropdown(){
        wait.until(ExpectedConditions.visibilityOf(firstRuleFirstDropdown));
        firstRuleFirstDropdown.click();
        getFirstRuleFirstDropdownInput.click();
        return this;

    }

    public SmartplaylistPage selectSecondDropdown(){
        wait.until(ExpectedConditions.visibilityOf(firstRuleSecondDropdown));
        firstRuleSecondDropdown.click();
        getFirstRuleSecondDropdownInput.click();
        return this;
    }


   public  SmartplaylistPage provideThirdFieldInput(String ruleInput){
        wait.until(ExpectedConditions.elementToBeClickable(thirdFieldInput));
        thirdFieldInput.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        thirdFieldInput.sendKeys(ruleInput);
        return this;

   }

   public SmartplaylistPage clickAddRule() {
       addRule.click();
       return this;
   }

    public  SmartplaylistPage selectSecondRulFirstDropdown() {
        wait.until(ExpectedConditions.visibilityOf(secondRuleFirstDropdownField));
        secondRuleFirstDropdownField.click();
        secondRuleFirstDropdownFieldOption.click();
        return this;
    }

    public  SmartplaylistPage selectSecondRulSecondDropdown() {
        wait.until(ExpectedConditions.visibilityOf(secondRuleSecondDropdownField));
        secondRuleSecondDropdownField.click();
        secondRuleSecondDropdownFieldOption.click();
        return this;
    }

    public  SmartplaylistPage provideSecondRuleThirdFieldInput(String ruleInput){
        wait.until(ExpectedConditions.elementToBeClickable(secondRuleThirdInputField));
        secondRuleThirdInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        secondRuleThirdInputField.sendKeys(ruleInput);
        return this;

    }
    public SmartplaylistPage clickAddGroup() {
        addGroup.click();
        return this;
    }
    public  SmartplaylistPage selectGroupFirstDropdown() {
        wait.until(ExpectedConditions.visibilityOf(groupFirstDropdownField));
        groupFirstDropdownField.click();
        groupFirstDropdownFieldOption.click();
        return this;
    }
    public  SmartplaylistPage selectGroupSecondDropdown() {
        wait.until(ExpectedConditions.visibilityOf(groupSecondDropdownField));
        groupSecondDropdownField.click();
        groupSecondDropdownFieldOption.click();
        return this;
    }
    public  SmartplaylistPage selectGroupThirdFieldInput(String groupinput) {
        wait.until(ExpectedConditions.elementToBeClickable(groupThirdFieldInput));
        groupThirdFieldInput.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        groupThirdFieldInput.sendKeys(groupinput);

        return this;
    }
   public void hitSave(){
        save.click();
   }

   public String getTextMessage(){
        wait.until(ExpectedConditions.visibilityOf(emptyPlaylistMsg));
        return emptyPlaylistMsg.getText();
   }
}
