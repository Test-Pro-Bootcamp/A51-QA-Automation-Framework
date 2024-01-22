import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileName() throws InterruptedException {
        navigateToLoginPage();
        provideEmail("zhanna.ivanova@testpro.io");
        providePassword("12345678");
        clickSubmit();
        Thread.sleep(2000);
        clickAvatar();
        Thread.sleep(2000);
        provideCurrentPassword("12345678");
        String randomName = generateRandomName();
        provideProfileName(randomName);
        clickSave();
        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }

    public void clickAvatar() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void provideProfileName(String name) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(name);
    }

    public void clickSave() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }
}

