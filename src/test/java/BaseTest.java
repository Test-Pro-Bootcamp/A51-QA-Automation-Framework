import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITest;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

/*
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

 */

public class BaseTest {

   public WebDriver driver;

   public String url = "https://qa.koel.app/";

    @DataProvider(name="LoginData")
    public Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"daria.chebotnyagina@testpro.io", "Asdfasdf1"},
                {"invalidEmail@testpro.io", "Asdfasdf1"},
                {"daria.chebotnyagina@testpro.io", "InvalidPassword"},
                {"",""}
        };
    }

    /*
    @DataProvider(name="excel-data")
    public Object[][] excelLDP() throws IOException{
        Object[][] arrObj = getExcelData("\\src\\test\\resources\\test.xlsx", "test.xlsx");
        return arrObj;
    }*/

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
 @BeforeMethod
 @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //url = BaseURL;
        navigateToLoginPage(BaseURL);

    }
@AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void navigateToLoginPage(String BaseURL){
        driver.get(BaseURL);
    }

    public void navigateToLoginPage(){
        driver.get(url);
    }

    public void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit(){
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    /*
    @Test(dataProvider = "excel-data")
    public void search(String keyword1, String keyword2){
        WebElement txtBox = driver.findElement(By.tagName("//input[@class='gLFYf gsfi']"));
        txtBox.sendKeys(keyword1, keyword2);
        Reporter.log("keyWord Entered is:"+keyword1+ " " +keyword2);
        txtBox.sendKeys(Keys.ENTER);
        Reporter.log("Search results are displayed.");
    }

    public String[][] getExcelData(String fileName, String sheetName){
        String [][] data = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = wb.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);

            int numOfRows = sheet.getPhysicalNumberOfRows();
            int numOfColumns = row.getLastCellNum();

            XSSFCell cell;
            data = new String[numOfRows-1][numOfColumns];

            for(int i=1; i<numOfRows; i++) {
            for(int j=0; j<numOfColumns; j++){
                row = sheet.getRow(i);
                cell = row.getCell(j);
                data [i-1][j] = cell.getStringCellValue();
              }
            }
        }  catch (Exception e) {
            System.out.println("Something went wrong." +e);
        }
        return data;
    }*/
}