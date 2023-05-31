package herokuapp.browserfectory.testsuite;

import herokuapp.browserfectory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
String baseUrl= "http://the-internet.herokuapp.com/login";

@Before
    public void openBrowser(){openBrowser(baseUrl);}
@Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
    WebElement enterUsername = driver.findElement(By.xpath("//form[@id='login']/div[1]/div[1]/input"));
    enterUsername.sendKeys("tomsmith");
    WebElement enterPassword = driver.findElement(By.xpath("//form[@id='login']/div[2]/div[1]/input"));
    enterPassword.sendKeys("SuperSecretPassword!");
    WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']/button/i"));
    loginButton.click();
    WebElement verifyMessage = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
    String actualText = verifyMessage.getText();
    System.out.println("Verifying Actual Text is: "+actualText);
    String expectedText = "Secure Area";
    Assert.assertEquals("Verify text",expectedText,actualText);
}
@Test
public void verifyTheUsernameErrorMessage(){
    WebElement invalidUsername = driver.findElement(By.xpath("//form[@id='login']/div[1]/div[1]/input"));
    invalidUsername.sendKeys("tomsmith1");
    WebElement enterPassword = driver.findElement(By.xpath("//form[@id='login']/div[2]/div[1]/input"));
    enterPassword.sendKeys("SuperSecretPassword!");
    WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']/button/i"));
    loginButton.click();
    WebElement errorMessage = driver.findElement(By.xpath("//div[@class='row']/div[1]/div[text()]"));
    String actualText = errorMessage.getText();
    System.out.println("Verify actual error message is: "+actualText);
    String expectedText = "Your username is invalid!";
    Assert.assertEquals("Verifying error text",expectedText,actualText);
}
@Test
public void verifyThePasswordErrorMessage(){
    WebElement invalidUsername = driver.findElement(By.xpath("//form[@id='login']/div[1]/div[1]/input"));
    invalidUsername.sendKeys("tomsmith");
    WebElement enterPassword = driver.findElement(By.xpath("//form[@id='login']/div[2]/div[1]/input"));
    enterPassword.sendKeys("SuperSecretPassword");
    WebElement loginButton = driver.findElement(By.xpath("//form[@id='login']/button/i"));
    loginButton.click();
    WebElement errorMessage = driver.findElement(By.xpath("//div[@class='row']/div[1]/div[text()]"));
    String actualText = errorMessage.getText();
    System.out.println("Verify actual error message is: "+actualText);
    String expectedText = "Your password is invalid!";
    Assert.assertEquals("verifying error text",expectedText,actualText);
}
@After
    public void closebrowser(){driver.quit();}






}

