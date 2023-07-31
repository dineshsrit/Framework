package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

    //private final By productName= By.xpath("//a[normalize-space()='Blue Shoes']");
   // private final By checkOutBtn= By.xpath("//a[normalize-space()='Proceed to checkout']");

    @FindBy(xpath = "//a[normalize-space()='Blue Shoes']") private WebElement productName;

    @FindBy(xpath = "//a[normalize-space()='Proceed to checkout']") @CacheLookup
    private WebElement checkOutBtn;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName()
    {
        //wait.until(ExpectedConditions)
        return productName.getText();
        //return driver.findElement(productName).getText();
    }

    public CheckOutPage clickCheckOutBtn()
    {
        getWait().until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
        //driver.findElement(checkOutBtn).click();
        return new CheckOutPage(driver);
    }

}
