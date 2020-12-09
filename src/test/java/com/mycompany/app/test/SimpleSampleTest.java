package com.mycompany.app.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleSampleTest {
    public String baseUrl = "https://cloud.google.com/products/calculator";
    public WebDriver driver;

    @Test
    public void launch() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String expectedTitle = "Google Cloud Platform Pricing Calculator";
        System.out.println(driver.getTitle());
        Assert.assertEquals(expectedTitle, driver.getTitle());
        driver.close();
    }
}
