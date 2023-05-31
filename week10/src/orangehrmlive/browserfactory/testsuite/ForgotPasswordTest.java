package orangehrmlive.browserfactory.testsuite;

import orangehrmlive.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl ="https://opensource-demo.orangehrmlive.com/";
@Before
public void setup(){OpenBrowser(baseUrl);}
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        String actualtext = forgotPasswordLink.getText();
        System.out.println("Actual text is: "+actualtext);
        forgotPasswordLink.click();
    }
@After
    public void closeBrowser(){driver.quit();}

}
