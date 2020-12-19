package com.mycompany.app.test;

import com.mycompany.app.driver.DriverSingleton;
import com.mycompany.app.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
