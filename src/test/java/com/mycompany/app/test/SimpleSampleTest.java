package com.mycompany.app.test;

import com.mycompany.app.driver.DriverSingleton;
import com.mycompany.app.model.CalculatorModel;
import com.mycompany.app.service.CalculatorModelCreator;
import com.mycompany.app.service.Service;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleSampleTest extends CommonConditions {
    private WebDriver driver = DriverSingleton.getDriver();
    private Service service = new Service();
    private CalculatorModel calculatorModel = CalculatorModelCreator.withCredentialsFromProperty();

    @BeforeClass
    public void openCalc() {
        service
                .openCloudGoogleCalculatorPage()
                .inputCalculatorData(calculatorModel)
        ;
    }

    @Test
    public void testSample() {
        System.out.println("this is sample test running");
    }
}
