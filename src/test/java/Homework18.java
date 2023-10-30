import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework18 extends BaseTest {

    @Test
    public void playSong(){
        openBrowser("https://qa.koel.app/");
        loginSite("demo@class.com", "te$t$tudent");
        playNextSong();
        playSongn();
        if(confirmPlay()){
            System.out.println("Song is Playing!");
        }
        else{
            System.out.println("Song is not Playing!");
        }
        closeBrowser();
    }
}
