package com.mycompany.app.test;

import com.mycompany.app.driver.DriverSingleton;
import com.mycompany.app.model.CalculatorModel;
import com.mycompany.app.page.CalculatorPage;
import com.mycompany.app.page.HomePage;
import com.mycompany.app.service.CalculatorModelCreator;
import com.mycompany.app.service.Service;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SimpleSampleTest extends CommonConditions {
    private WebDriver driver = DriverSingleton.getDriver();
    private Service service = new Service();
    private CalculatorModel calculatorModel = CalculatorModelCreator.withCredentialsFromProperty();
    private Double estimationPageCost;

    @Test
    public void openPage() {
        CalculatorPage calculatorPage = new HomePage(driver)
                .openPage()
                .returnSearchResult("Google Cloud Platform Pricing Calculator")
                .openCalculator()
                .activateFrame()
                .selectComputeEngine()
                .inputNumberOfInstances(calculatorModel.getNumberOfInstances())
                .inputOS(calculatorModel.getOperatingSystem())
                //.inputOS()
                .inputMachineClass(calculatorModel.getMachineClass())
                .inputSeries(calculatorModel.getSeries())
                .inputMachineType(calculatorModel.getMachineType())
                .inputGPU(calculatorModel.getAddGPU(), calculatorModel.getNumberOfGPUs(), calculatorModel.getGPUtype())
                .inputSSD(calculatorModel.getLocalSSD())
                .inputLocation()
                .inputCommitedUsage()
                .addToEstimate();
        //.openNewTab()
    }
}
