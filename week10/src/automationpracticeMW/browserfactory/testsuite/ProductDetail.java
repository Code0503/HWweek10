package automationpracticeMW.browserfactory.testsuite;

import automationpracticeMW.browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetail extends BaseTest {
    String baseUrl ="http://automationexercise.com";

    @Before
    public void setUp(){openBrowser(baseUrl);}
    @Test
    public void productDetailPage() {
        //verify user on homepage
        WebElement homePage = driver.findElement(By.xpath("//div[@class='col-sm-8']/div/ul/li"));
        String actualText = homePage.getText();
        String expecteText = "Home";
        Assert.assertEquals("verifying user on Home page", expecteText, actualText);
        //select Product button
        WebElement selectProduct = driver.findElement(By.xpath("//div[@class='col-sm-8']/div/ul/li[2]"));
        selectProduct.click();
        //Verify user is navigated to All Product page
        WebElement allProductPage = driver.findElement(By.xpath("//div[@class='features_items']/h2"));
        String actualtext = allProductPage.getText();
        String expectetext = "FEATURES ITEMS";
        Assert.assertEquals("Verifying All Products message visible to user", expectetext, actualtext);
////list of all products
        WebElement featureProducts = driver.findElement(By.xpath("div[@class='features_items']"));
        String allProducts = featureProducts.getText();
        System.out.println(allProducts);

       /* for (WebElement nameOfProducts:allProducts) {
            if(nameOfProducts.){

        }*/
    }
        @Test
                public void searchProduct(){
            //verify user on homepage
            WebElement homePage = driver.findElement(By.xpath("//div[@class='col-sm-8']/div/ul/li"));
            String actualText = homePage.getText();
            String expectedText = "Home";
            Assert.assertEquals("verifying user on Home page", expectedText, actualText);
            //select Product button
            WebElement selectProduct = driver.findElement(By.xpath("//div[@class='col-sm-8']/div/ul/li[2]"));
            selectProduct.click();
            //Verify user is navigated to All Product page
            WebElement allProductPage = driver.findElement(By.xpath("//h2[@class='title text-center']"));
            String actualTextProductList = allProductPage.getText();
            String expectedTextProductList = "ALL PRODUCTS";
            Assert.assertEquals("Verifying All Products message visible to user", expectedTextProductList,actualTextProductList);
            //SEARCH PRODUCT BY PRODUCT NAME
            WebElement searchProduct = driver.findElement(By.id("search_product"));
            searchProduct.sendKeys("Blue Top");
            WebElement searchButton =driver.findElement(By.id("submit_search"));
            searchButton.click();
            //verify text
            WebElement serchProduct = driver.findElement(By.xpath("//div[@class='features_items']/h2"));
            String actualSPText= searchProduct.getText();
            String expectedSPText = "SEARCHED PRODUCTS";
            Assert.assertEquals("verifying text",expectedSPText,actualSPText);
            //product related search are visible
            WebElement productDetail = driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']/div/div[2]/div"));
            productDetail.getText();
            System.out.println(productDetail);





    }
}
