package ultimateqa.browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void  openBrowser(String Url){
        ChromeOptions options = new ChromeOptions();
        driver= new ChromeDriver(options);
        driver.get(Url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

    }
    public void closeBrowser(){driver.quit();}
}
