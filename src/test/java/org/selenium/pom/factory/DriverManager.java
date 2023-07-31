package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.constants.DriverType;

import java.time.Duration;

public class DriverManager {


    public WebDriver initializeDriver(String browser)
    {
        WebDriver driver;
        //String localbrowser;
        browser=System.getProperty("browser", browser);
        //localbrowser=browser;

        switch (DriverType.valueOf(browser))
        {
            case CHROME:
                System.setProperty("webdriver.chrome.driver","D:\\MasterFramework\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver=new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver","D:\\MasterFramework\\geckodriver.exe");
                driver=new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser:" +browser);

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;

       /*//System.setProperty("webdriver.chrome.driver","D:\\MasterFramework\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","D:\\MasterFramework\\geckodriver.exe");
        //WebDriverManager.chromedriver().setup();
       // ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--remote-allow-origins=*");
        // WebDriver driver= new ChromeDriver(chromeOptions);
        WebDriver*/


    }
}
