package nopcommerce.browserfactory.testsuite;

import nopcommerce.browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUP(){openBrowser(baseUrl);}

    @Test
    public void computertab(){
        WebElement computerTab = driver.findElement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[1]/a"));
        computerTab.click();
        WebElement pagetitle= driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        String actualTabname= pagetitle.getText();
        String expectedTabname= "Computers";
        Assert.assertEquals("Computers",expectedTabname,actualTabname);
    }
@Test
public void userShouldNavigateToElectronicsPageSuccessfully(){
        WebElement eletronicsTab =driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]"));
        eletronicsTab.click();
        WebElement tabText = driver.findElement(By.xpath("//a[text()='Electronics ']"));
    String actualText= tabText.getText();
    System.out.println("actualText : "+actualText);
        String expectedText = "Electronics";
        Assert.assertEquals("Verifiying Electronics tab name: ",expectedText,actualText);
}
@Test
public void userShouldNavigateToApparelPage(){
        WebElement apparelTab= driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[3]"));
        apparelTab.click();
        WebElement tabText= driver.findElement(By.xpath("//a[text()='Apparel ']"));
        String actualText = tabText.getText();
    System.out.println("actualText of the page is : "+actualText);
    String expectedText = "Apparel";
    Assert.assertEquals("Verifying tab name",expectedText,actualText);
}
@Test
public void userNavigateToDigitalDownloadsPage(){
        WebElement digitalDowntoladTab = driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[4]"));
        digitalDowntoladTab.click();
        WebElement tabText = driver.findElement(By.xpath("//a[text()='Digital downloads ']"));
        String actualText = tabText.getText();
    System.out.println("Actual tab name is : "+actualText);
    String expectedtext = "Digital downloads";
    Assert.assertEquals("veryfying text of tab: ",actualText,expectedtext);

    }
    @Test
    public void UserNavigateToBooksPage(){
       WebElement bookTab= driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[5]"));
       bookTab.click();
       WebElement tabText = driver.findElement(By.xpath("//a[text()='Books ']"));
       String actualText = tabText.getText();
        System.out.println("Actual Text of tab is :"+actualText);
        String expectedText= "Books";
        Assert.assertEquals("Verfing text of the tab",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToJewelryPage(){
        WebElement jewelTab= driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[6]"));
        jewelTab.click();
        WebElement tabText = driver.findElement(By.xpath("//a[text()='Jewelry ']"));
        String actualText = tabText.getText();
        System.out.println("Actual text of the tab is: "+actualText);
        String expectedText ="Jewelry";
        Assert.assertEquals("Veryfing Text of the tab",expectedText,actualText);
    }
    @Test
    public void userShouldNavigateToGiftCardsPage(){
        WebElement giftCardTab= driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[7]"));
        giftCardTab.click();
        WebElement tabText = driver.findElement(By.xpath("//a[text()='Gift Cards ']"));
        String actualText = tabText.getText();
        System.out.println("Actual text of tab is: "+actualText);
        String expectedText = "Gift Cards";
        Assert.assertEquals("Verfying name of the tab",expectedText,actualText);
    }
 @After
    public void CloseBrowser(){driver.close();}
}
