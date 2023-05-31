package orangehrmlive.browserfactory.testsuite;

import orangehrmlive.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup() {
        OpenBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        WebElement enterUsername = driver.findElement(By.name("username"));
        enterUsername.sendKeys("Admin");
        WebElement enterpassword = driver.findElement(By.name("password"));
        enterpassword.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }
@After
    public void closeBrowser(){driver.quit();}
}