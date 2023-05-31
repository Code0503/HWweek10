package nopcommerce.browserfactory.testsuite;

import nopcommerce.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public  void setUp(){ openBrowser(baseUrl);}
    @Test
    public void callLogin(){
        WebElement loginLink= driver.findElement(By.className("ico-login"));
        loginLink.click();

        WebElement WelcomeMessage= driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = WelcomeMessage.getText();
        String expectedmessage = "Welcome, Please Sign In!";
        Assert.assertEquals("Verifiying welcome Message : ",expectedmessage,actualMessage);
    }

    @Test
    public void test2(){
        WebElement loginLink= driver.findElement(By.className("ico-login"));
        loginLink.click();

WebElement emailField = driver.findElement(By.id("Email"));
emailField.sendKeys("pani@yahoo.com");

WebElement passwordField =driver.findElement(By.name("Password"));
passwordField.sendKeys("123456");

WebElement LoginButton = driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]"));
LoginButton.click();

WebElement logOutText = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
         String  lgout = logOutText.getText();
        System.out.println(lgout);
    }

@Test
    public void Test3(){
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();
        WebElement enterEmail= driver.findElement(By.id("Email"));
        enterEmail.sendKeys("pani@face.com");
        WebElement enterPassword = driver.findElement(By.id("Password"));
        enterPassword.sendKeys("123456@");
        WebElement LoginButton= driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]"));
        LoginButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]"));
        String Error= errorMessage.getText();
    System.out.println("Error Message is: "+Error);
}



@After
    public void closetabs(){driver.close();}



}
