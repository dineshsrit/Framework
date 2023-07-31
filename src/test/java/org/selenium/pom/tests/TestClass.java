package org.selenium.pom.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestClass {


    @Test
    public void test()
    {
        System.setProperty("webdriver.chrome.driver","D:\\MasterFramework\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
       WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://askomdch.com");
    }
}
