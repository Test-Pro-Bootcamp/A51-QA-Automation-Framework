import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest{

    @Test
    public void changeProfileName()throws InterruptedException{
        //navigateToLoginPage();
        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();
        Thread.sleep(2000);

        clickAvatar();
        provideCurrentPassword("Asdfasdf1");
        String randomName = generateRandomName();
        provideProfileName(randomName);
        clickSave();
        Thread.sleep(2000);

        WebElement actualProfileName = driver.findElement(By.cssSelector("span[class='name']"));
        Assert.assertEquals(actualProfileName.getText(),randomName);

    }

    public void clickAvatar(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String password){
        WebElement currentPassword = driver.findElement(By.cssSelector("input[name='current_password']"));
    currentPassword.clear();
    currentPassword.sendKeys(password);
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }
    public void provideProfileName(String name){
        WebElement profileName = driver.findElement(By.cssSelector("input[id='inputProfileName']"));
        profileName.clear();
        profileName.sendKeys(name);
    }
    public void clickSave(){
        WebElement saveButton = driver.findElement(By.cssSelector("button[class='btn-submit']"));
        saveButton.click();
    }
}
