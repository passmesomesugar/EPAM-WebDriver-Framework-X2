package com.mycompany.app.test;

import com.mycompany.app.driver.DriverSingleton;
import com.mycompany.app.model.CalculatorModel;
import com.mycompany.app.service.CalculatorModelCreator;
import com.mycompany.app.service.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleSampleTest extends CommonConditions {
    private WebDriver driver = DriverSingleton.getDriver();
    private Service service = new Service();
    private CalculatorModel calculatorModel = CalculatorModelCreator.withCredentialsFromProperty();
    private Double estimationPageCost;

    @BeforeClass
    public void openCalc() {
        estimationPageCost = service
                .openCloudGoogleCalculatorPage()
                .inputCalculatorData(calculatorModel)
                .getAnEstimatePrice()
        ;
    }

    private Logger log = LogManager.getRootLogger();

    @Test
    public void testSample() {
        System.out.println("this is sample test running");
        System.out.println(estimationPageCost);
        log.info("estimationPageCost: " + estimationPageCost);
    }
}
