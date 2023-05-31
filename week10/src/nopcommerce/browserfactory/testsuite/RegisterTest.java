package nopcommerce.browserfactory.testsuite;

import nopcommerce.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openingBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPage() {
        //click on the ‘Register’ link
        WebElement registerLink = driver.findElement(By.xpath("//div[@class='header-links']/ul[1]/li[1]"));
        registerLink.click();
        //Verify the text ‘Register’
        WebElement verifyText = driver.findElement(By.xpath("//h1[text()='Register']"));
        String actualText = verifyText.getText();
        System.out.println("Actual text of the page is : " + actualText);
        String expectedText = "Register";
        Assert.assertEquals("Verfy text of page", expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccount() {
        WebElement registerLink = driver.findElement(By.xpath("//div[@class='header-links']/ul[1]/li[1]"));
        registerLink.click();  // click on the ‘Register’ link
        // Select gender radio button
        WebElement selectGender = driver.findElement(By.xpath("//input[@id='gender-male']"));
        selectGender.click();
        //Enter First name
        WebElement selectFisrtnamefield = driver.findElement(By.id("FirstName"));
        selectFisrtnamefield.sendKeys("Code");
        //Enter Last name
        WebElement selectLastname = driver.findElement(By.xpath("//input[@id='LastName']"));
        selectLastname.sendKeys("Buster");
//Select Day Month and Year
        //WebElement selectDay = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[1]/option[6]"));
        WebElement selectDay = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[1]"));
        selectDay.sendKeys("5");
        WebElement selectMonth = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[2]"));
        selectMonth.sendKeys("12");
        WebElement selectYear = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[3]"));
        selectYear.sendKeys("2023");
//Enter Email address
        WebElement enterEmail = driver.findElement(By.xpath("//input[@id='Email']"));
        enterEmail.sendKeys("pani@yahoo.com");
        //Enter password
        WebElement enterPassword = driver.findElement(By.xpath("//input[@id='Password']"));
        enterPassword.sendKeys("123456");
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("123456");
        //click on register button
        WebElement registerButton = driver.findElement(By.xpath("//button[@id='register-button']"));
        registerButton.click();
        //Verify the text 'registration completed'
        WebElement verifyText = driver.findElement(By.xpath("//div[text()='Your registration completed']"));
        String actualText = verifyText.getText();
        String expectedText = "Your registration completed";
        Assert.assertEquals("Verify the Text", expectedText, actualText);
    }
@After
    public void closeTabs(){driver.close();}
}