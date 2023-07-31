package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {

   private final By storeMenuLink= By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load()
    {
        load("/");
        return this;
    }

    public StorePage clickStoreMenuLink()
    {
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }



}
