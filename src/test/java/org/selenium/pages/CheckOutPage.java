package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;

public class CheckOutPage extends BasePage {

    private final By firstName=By.id("billing_first_name");
    private final By lastName=By.id("billing_last_name");
    private final By  billingAddress=By.id("billing_address_1");
    private final By billingCity=By.id("billing_city");
    private final By billingPostCode=By.id("billing_postcode");
    private final By billingEmail=By.id("billing_email");

    private final By placeOrder=By.xpath("//*[text()='Place order']");

    private final By orderConfirmation= By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");

    private final By billingCountry=By.id("billing_country");

    private final By billingState=By.id("billing_state");

    private final By directBankTransfer=By.id("payment_method_bacs");
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }



    public CheckOutPage enterFirstName(String text)
    {
        driver.findElement(firstName).sendKeys(text);
        return this;
    }
    public  CheckOutPage enterLastname(String txt)
    {
        driver.findElement(lastName).sendKeys(txt);
        return this;
    }

    public CheckOutPage enterBillingAddress(String txt)
    {
        driver.findElement(billingAddress).sendKeys(txt);
        return this;
    }

    public CheckOutPage enterBillingCity(String txt)
    {
        driver.findElement(billingCity).sendKeys(txt);
        return this;
    }

    public CheckOutPage enterBillingPostCode(String txt)
    {
        driver.findElement(billingPostCode).sendKeys(txt);
        return this;
    }

    public CheckOutPage enterBillingEmail(String txt)
    {
        driver.findElement(billingEmail).sendKeys(txt);
        return this;
    }

    public CheckOutPage ClickPlaceOrder()
    {
        driver.findElement(placeOrder).click();
        return this;
    }

    public String getOrderConfirnmation()
    {
        return driver.findElement(orderConfirmation).getText();
    }

    public CheckOutPage selectCountry(String country)
    {
        Select select= new Select(driver.findElement(billingCountry));
        select.selectByVisibleText(country);
        return this;
    }

    public CheckOutPage selectState(String state)
    {
        Select select= new Select(driver.findElement(billingState));
        select.selectByVisibleText(state);
        return this;
    }

    public CheckOutPage isBankTransferSelected()
    {
     WebElement banktransfer= getWait().until(ExpectedConditions.elementToBeClickable(directBankTransfer));
     if(!banktransfer.isSelected())
     {
        banktransfer.click();
     }

     return this;

    }

}
