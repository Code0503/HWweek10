package automationpracticeMW.browserfactory.testsuite;

import automationpracticeMW.browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends BaseTest {
    String baseUrl =  "http://automationexercise.com";

    @Before
    public void setUp(){openBrowser(baseUrl);
    driver.getTitle();}

    @Test
    public void  UserAbleToLoginWithValidEmailAndValidPassword(){
        WebElement SignupLogin = driver.findElement(By.xpath("//header[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"));
        SignupLogin.click();

        WebElement verifyText = driver.findElement(By.xpath("//div[@class='login-form']/h2"));
        String actualText = verifyText.getText();
        System.out.println("Verifying Text for login page is: "+actualText);
        String expectedText = "Login to your account";
        Assert.assertEquals("verifying Text ",expectedText,actualText);

        WebElement validEmail = driver.findElement(By.name("email"));
        validEmail.sendKeys("pani@yahoo.com");
        WebElement validPassword = driver.findElement(By.name("password"));
        validPassword.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement verifylogedUsername = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[10]/a"));
        String UserName = verifylogedUsername.getText();
        System.out.println("Verifying user : " +UserName);


        /*WebElement deleteAccount = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[5]/a"));
        deleteAccount.click();
        WebElement verifyaccountDeleted = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']/b']"));
        String deletedAccount=verifyaccountDeleted.getText();
        System.out.println("verifying message: "+verifyaccountDeleted);
        String expectedDeletedText = "ACCOUNT DELETED!";
        Assert.assertEquals("verify account is deleted",expectedDeletedText,actualText);*/
    }
    @Test
    public void LoginWithInvalidEmailAndPassword(){


        WebElement SignupLogin = driver.findElement(By.xpath("//header[@id='header']/div/div/div/div[2]/div/ul/li[4]/a"));
        SignupLogin.click();

        WebElement VerifyLoginPage= driver.findElement(By.xpath("//div[@class='login-form']/h2"));
        String actualText = VerifyLoginPage.getText();
        String expectedText="Login to your account";
        Assert.assertEquals("Verify user on login to your account page",expectedText,actualText);

        WebElement invalidEmail = driver.findElement(By.name("email"));
        invalidEmail.sendKeys("nipa@ni.com");
        WebElement invalidPassword = driver.findElement(By.name("password"));
        invalidPassword.sendKeys("@12.%");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
loginButton.click();
WebElement getInvalidmessage = driver.findElement(By.xpath("//form[@action='/login']/p"));
String actualmessage = getInvalidmessage.getText();
String expectedmessage = "Your email or password is incorrect!";
Assert.assertEquals("verify invalid message",expectedmessage,actualmessage);
    }
    @Test
    public void logOutUSer() {
        //signup/login
        WebElement login = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]/a"));
        login.click();
        //enter email and password
        WebElement enterEmail = driver.findElement(By.name("email"));
        enterEmail.sendKeys("pani@yahoo.com");
        WebElement enterPassword = driver.findElement(By.name("password"));
        enterPassword.sendKeys("123456");
        //click login button
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='login-form']/form/button"));
        loginButton.click();
        // verify user loged in as
        WebElement getNmaeUserlogedAs = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[10]/a"));
        String actualTextloggedAs = getNmaeUserlogedAs.getText();
        String expectedTextloggedAs = "Logged in as java";
        Assert.assertEquals("verifying text", expectedTextloggedAs, actualTextloggedAs);
        //Logout button
        WebElement logoutButton = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']/ul/li[4]"));
        logoutButton.click();
        //verify user is navigated to login page
        WebElement loginSignup = driver.findElement(By.xpath("//div[@class='login-form']/h2"));
        String actualText = loginSignup.getText();
        String expectedText = "Login to your account";
        Assert.assertEquals("verify text", expectedText, actualText);
    }
    @Test
    public void UserEmailexists(){

        //verify user on hamepage
        WebElement userOnHomePage = driver.findElement(By.xpath("//div[@class='col-sm-8']/div[1]/ul[1]/li[1]"));
        String actualHomeText =  userOnHomePage.getText();
        String expectedHomeText ="Home";
        Assert.assertEquals("verify user on homepage",expectedHomeText,actualHomeText);

        //click signup/login button
        WebElement signupLogin = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]"));
        signupLogin.click();

        //verify new user sign up message
        WebElement signupMessage = driver.findElement(By.xpath("//div[@class='signup-form']/h2"));
        String actualMessage = signupMessage.getText();
        String expectedMessage = "New User Signup!";
        Assert.assertEquals("verifying message",expectedMessage,actualMessage);

        //enter username and email
        WebElement enterUsername =driver.findElement(By.xpath("//div[@class='signup-form']/form/input[2]"));
        enterUsername.sendKeys("java");
        WebElement enterEmail = driver.findElement(By.xpath("//div[@class='signup-form']/form/input[3]"));
        enterEmail.sendKeys("pani@yahoo.com");
        WebElement signupButton = driver.findElement(By.xpath("//div[@class='signup-form']/form/button"));
        signupButton.click();

        //verify error 'Email address exist message
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='signup-form']/form/p"));
        String actualText =errorMessage.getText();
        String expectedText = "Email Address already exist!";
        Assert.assertEquals("verifying error message",expectedText,actualText);

    }


    public void tearDown(){driver.quit();}


}
