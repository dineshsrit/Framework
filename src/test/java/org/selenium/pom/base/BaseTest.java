package org.selenium.pom.base;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

   // protected WebDriver driver;


    ThreadLocal<WebDriver> driver= new ThreadLocal<>();

    private void setDriver(WebDriver driver)
    {
        this.driver.set(driver);
    }

    protected WebDriver getDriver()
    {
        return driver.get();
    }



    @Parameters("browser")

    @BeforeMethod
    public void startDriver(@Optional String browser)
    {
        /*if (browser== null)
            browser="CHROME";*/
        setDriver(new DriverManager().initializeDriver(browser));
        System.out.println("Current Thread: "+ Thread.currentThread().getId() + " , " + "Driver=" +getDriver());

    }

   @AfterMethod
    public void quitDriver() {
        System.out.println("Quit Thread: "+ Thread.currentThread().getId() + " , " + "Driver=" +getDriver());
        //Thread.sleep(3000);
        getDriver().quit();
    }
}
