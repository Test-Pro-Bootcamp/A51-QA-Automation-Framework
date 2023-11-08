package PageObjectModel;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


    public boolean isAvatarDisplayed() {
        return true;
    }
}

