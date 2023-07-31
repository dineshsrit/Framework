package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.utilis.ConfigLoader;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;



    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void load(String endpoint)
    {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endpoint );
    }

    public WebDriverWait getWait() {
        return wait;
    }




}
