package ultimateqa.browserfactory.testsuite;

import ultimateqa.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setup(){openBrowser(baseUrl);}
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        WebElement signIn = driver.findElement(By.xpath("//div[@class='header__wrapper']/nav/ul/li/a"));
        signIn.click();

        WebElement welcomeText = driver.findElement(By.xpath("//div[@class='sign-in__wrapper']/article/h2"));
        String actualText = welcomeText.getText();

        System.out.println("Verfiying welcome message Text : "+actualText);
        String expectedtext = "Welcome Back!";
        Assert.assertEquals("verifying Text",expectedtext,actualText);
    }
@Test
public void verifyTheErrorMessage(){
        WebElement signinLink = driver.findElement(By.xpath("//header[@class='header']/div[2]/div/nav/ul/li/a"));
        signinLink.click();

        WebElement invlaidUsername = driver.findElement(By.xpath("//input[@id='user[email]']"));
        invlaidUsername.sendKeys("Codebuster@code.com");

        WebElement invalidPassword = driver.findElement((By.xpath("//input[@id='user[password]']")));
        invalidPassword.sendKeys("Buster");

        WebElement signinbutton = driver.findElement(By.xpath("//button[@type='submit']"));
        signinbutton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='notice']/ul/li"));
        String actualText = errorMessage.getText();
    System.out.println("verifying actual error text: "+actualText);
    String expectedText = "Invalid email or password.";
    Assert.assertEquals("verifying error text",actualText,expectedText);
}
@After
    public void closeBrowser(){driver.quit();}

}
