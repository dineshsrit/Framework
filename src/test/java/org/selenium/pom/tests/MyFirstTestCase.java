package org.selenium.pom.tests;

import org.openqa.selenium.By;
import org.selenium.pages.CartPage;
import org.selenium.pages.CheckOutPage;
import org.selenium.pages.HomePage;
import org.selenium.pages.StorePage;
import org.selenium.pom.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void dummyTestCases() throws InterruptedException {



        StorePage storePage= new HomePage(getDriver()).load().clickStoreMenuLink().search("blue");

        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”" );
       storePage.clickOnAddToCartBtn("Blue Shoes");
       //Thread.sleep(5000);
       CartPage cartPage= storePage.clickViewCartLink();
       Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");

       CheckOutPage checkOutPage= cartPage.clickCheckOutBtn();
       checkOutPage.enterFirstName("rakesh").enterLastname("k")
               .selectCountry("India")
               .enterBillingAddress("address")
               .enterBillingCity("Bangalore")
               .selectState("Karnataka")
               .enterBillingEmail("rakesh@gmail.com").enterBillingPostCode("560023")
               .isBankTransferSelected()
                       .ClickPlaceOrder();
        //Thread.sleep(3000);
        Assert.assertEquals(checkOutPage.getOrderConfirnmation(), "Thank you. Your order has been received.");





        /*Thread.sleep(1000);
        driver.findElement(By.cssSelector("li[id='menu-item-1228'] a[class='menu-link']")).click();
        driver.findElement(By.xpath("//input[@id='woocommerce-product-search-field-0']")).sendKeys("blue");
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Search results: “blue”')]")).getText(), "Search results: “blue”");
        driver.findElement(By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='View cart']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[normalize-space()='Blue Shoes']")).getText(), "Blue Shoes");
        driver.findElement(By.xpath("//a[normalize-space()='Proceed to checkout']")).click();*/
/*


        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("l");
        driver.findElement(By.id("billing_address_1")).sendKeys("233");
        driver.findElement(By.id("billing_city")).sendKeys("Bangalore");
        driver.findElement(By.id("billing_postcode")).sendKeys("76787");
        driver.findElement(By.id("billing_email")).sendKeys("demo@gmail.com");
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")).getText(),"Thank you. Your order has been received.");
*/



    }

    @Test
    public void someTest()
    {
        StorePage storePage= new HomePage(getDriver()).load().clickStoreMenuLink().search("blue");

        Assert.assertEquals(storePage.getTitle(), "Search results: “blue”" );
    }
}
