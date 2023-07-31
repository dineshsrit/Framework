package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {

    private final By searchFld = By.xpath("//input[@id='woocommerce-product-search-field-0']");
    private final By searchBtn= By.xpath("//button[normalize-space()='Search']");
    private final By title= By.xpath("//h1[contains(text(),'Search results: “blue”')]");

    private final By storeTitle=By.cssSelector(".woocommerce-products-header__title.page-title");

    private final By viewCartLink= By.xpath("//a[@title='View cart']");




    public StorePage(WebDriver driver) {
        super(driver);
    }


    public StorePage search(String txt)
    {
        enterTextInSearchFld(txt).clickOnSearchBtn();
        return this;
    }
    private StorePage enterTextInSearchFld(String txt)
    {
        driver.findElement(searchFld).sendKeys(txt);
        return this;
    }

    private StorePage clickOnSearchBtn()
    {
        driver.findElement(searchBtn).click();
        return this;
    }

    public String getTitle()
    {
      return  driver.findElement(title).getText();
    }

    private By clickOnAddtoCartBtnElement(String Productname)
    {
      return By.xpath("//a[@aria-label='Add “"+Productname+"” to your cart']");
    }

    public StorePage clickOnAddToCartBtn(String Productname)
    {
        By addtoCartBtn= clickOnAddtoCartBtnElement(Productname);
        driver.findElement(addtoCartBtn).click();
        return this;
    }

    public CartPage clickViewCartLink()
    {
        getWait().until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        //driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }

    public String getStoreTitle()
    {
        return driver.findElement(storeTitle).getText();
    }
}
