package saucedemo.browserfactory.testsuite;

import saucedemo.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String browerUrl ="https://www.saucedemo.com/";

    @Before
    public void setUpBrowser(){openBrowser(browerUrl);}
    @Test
    public void userShouldLoginWithValidCredentials(){
        WebElement enterUsername = driver.findElement(By.xpath("//input[@id='user-name']"));
        enterUsername.sendKeys("standard_user");

        WebElement enterPassword = driver.findElement(By.xpath("//input[@id='password']"));
        enterPassword.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement verifyText = driver.findElement(By.xpath("//div[@id='root']/div[1]/div[1]/div[1]/div[2]/span"));
        String actualText = verifyText.getText();
        System.out.println("verifying actual Text is: "+actualText);
        String expectedText = "Products";
        Assert.assertEquals("verifying prodcut text",expectedText,actualText);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        WebElement enterUsername = driver.findElement(By.xpath("//input[@id='user-name']"));
        enterUsername.sendKeys("standard_user");

        WebElement enterPassword = driver.findElement(By.xpath("//input[@id='password']"));
        enterPassword.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

    WebElement backpack = driver.findElement(By.linkText("Sauce Labs Onesie"));
    String actualbackpackText = backpack.getText();
        System.out.println("1st product : "+actualbackpackText);
        String exptectedBackpackText = "Sauce Labs Onesie";
        Assert.assertEquals("Verify prduct text",actualbackpackText,exptectedBackpackText);

        WebElement Labonesize = driver.findElement(By.linkText("Sauce Labs Backpack"));
        String actualLaboneText = Labonesize.getText();
        System.out.println("2nd product : "+actualLaboneText);
        String expectedLaboneText ="Sauce Labs Backpack";
        Assert.assertEquals("verifying name",actualLaboneText,expectedLaboneText);

        WebElement BoltT = driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt"));
        String actualBoltT = BoltT.getText();
        System.out.println("3rd product : "+actualBoltT);
        String expectedBoltT = "Sauce Labs Bolt T-Shirt";
        Assert.assertEquals("verifying name",actualBoltT,expectedBoltT);

        WebElement bikeLight = driver.findElement(By.linkText("Sauce Labs Bike Light"));
        String actualbikelight = bikeLight.getText();
        System.out.println("4th product : "+actualbikelight);
        String expectedbikelight ="Sauce Labs Bike Light";
        Assert.assertEquals("verifying name", actualbikelight,expectedbikelight);

        WebElement fleeJacket = driver.findElement(By.linkText("Sauce Labs Fleece Jacket"));
        String actualfleejacket = fleeJacket.getText();
        System.out.println("5th product : "+actualfleejacket);
        String expectedflejacked = "Sauce Labs Fleece Jacket";
        Assert.assertEquals("verifiying name",actualfleejacket,expectedflejacked);

        WebElement redTshirt = driver.findElement(By.linkText("Test.allTheThings() T-Shirt (Red)"));
        String actualredtshirt = redTshirt.getText();
        System.out.println("6th product : "+actualredtshirt);
        String expectedredtshirt ="Test.allTheThings() T-Shirt (Red)";
        Assert.assertEquals("Verifying name",actualredtshirt,expectedredtshirt);

    }
   @After
   public void closeBrowser(){driver.quit();}
}
