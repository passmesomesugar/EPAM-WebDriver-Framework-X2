package com.mycompany.app.test;

import com.mycompany.app.driver.DriverSingleton;
import com.mycompany.app.service.Service;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleSampleTest extends CommonConditions {
    private WebDriver driver = DriverSingleton.getDriver();
    private Service service = new Service();

    @BeforeClass
    public void openCalc() {
        service
                .openCloudGoogleCalculatorPage()
                .inputCalculatorData()
        ;
    }

    @Test
    public void testSample() {
        System.out.println("this is sample test running");
    }
}
