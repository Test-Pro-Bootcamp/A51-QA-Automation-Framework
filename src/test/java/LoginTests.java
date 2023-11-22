import Pages.HomePage;
import Pages.LoginPage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginTests extends BaseTest {

    @Test
    public void loginSuccessTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmailToLogin("daria.chebotnyagina@testpro.io")
                .providePasswordToLogin("Asdfasdf1")
                .clickSubmitBtnToLogin();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
    @Test
    public void loginInvalidCredentials(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmailToLogin("")
                .providePasswordToLogin("Asdfasdf1")
                .clickSubmitBtnToLogin();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
/*
    @Test(dataProvider = "LoginData")
    public void loginValidEmailPasswordTest(String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.provideSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    //LoginPage loginPage = new LoginPage(driver);
    //HomePage homePage = new HomePage(driver);
    @Test
    public void loginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
       HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("daria.chebotnyagina@testpro.io");
        loginPage.providePassword("Asdfasdf1");
        loginPage.provideSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginValidEmailPasswordPageFactory() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmailToLogin("daria.chebotnyagina@testpro.io")
                .providePasswordToLogin("Asdfasdf1")
                .clickSubmitBtnToLogin();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

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

        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        //WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
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
        try {
            Thread.sleep(2000);
            provideEmail(email);
            providePassword(password);
            Thread.sleep(2000);
            //WebElement txtBox = driver.findElement(By.tagName("//input[@class='gLFYf gsfi']"));
            //txtBox.sendKeys(keyword1, keyword2);
            Reporter.log("keyWord Entered is:" + email + " " + password);
            //txtBox.sendKeys(Keys.ENTER);
            clickSubmit();
            WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatar.isDisplayed());
            Reporter.log("Successfully Logged in.");
        } catch (Exception e){
Reporter.log("Unable to login with Excel Data for an unknown reason.");
        }
    }

    public void waitForAnElementToBeVisible(String cssLocator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
    }
*/
}
