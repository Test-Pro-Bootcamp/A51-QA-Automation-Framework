import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginTests extends BaseTest {


    @Test(dataProvider = "LoginData")
    public void loginTests(String email, String password) throws InterruptedException{
    provideEmail(email);
    providePassword(password);
    clickSubmit();
    Thread.sleep(2000);
    //Assert.assertEquals(driver.getCurrentUrl(), url);
    WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
    Assert.assertTrue(avatar.isDisplayed());

    }

    @Test
    public void loginValidEmailPassword(){

        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
    }
    @Test
    public void loginInvalidEmailValidPassword(){

        provideEmail("invalidEmail@testpro.io");
        providePassword("Asdfasdf1");
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void loginValidEmailInvalidPassword() throws InterruptedException{

        provideEmail("daria.chebotnyagina@testpro.io");
        providePassword("InvalidPassword");
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
    }


    @Test(dataProvider = "excel-data")
    public void loginWithExcelData(String email, String password){
        provideEmail(email);
        providePassword(password);
        //WebElement txtBox = driver.findElement(By.tagName("//input[@class='gLFYf gsfi']"));
        //txtBox.sendKeys(keyword1, keyword2);
        Reporter.log("keyWord Entered is:"+email+ " " +password);
        //txtBox.sendKeys(Keys.ENTER);
        clickSubmit();
        Reporter.log("Successfully Logged in.");
    }
}
