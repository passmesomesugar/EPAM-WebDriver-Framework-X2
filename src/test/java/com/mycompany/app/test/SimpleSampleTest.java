package com.mycompany.app.test;

import com.mycompany.app.driver.DriverSingleton;
import com.mycompany.app.model.CalculatorModel;
import com.mycompany.app.page.CalculatorPage;
import com.mycompany.app.page.HomePage;
import com.mycompany.app.page.MailService;
import com.mycompany.app.service.CalculatorCreator;
//import com.mycompany.app.service.Service;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class SimpleSampleTest extends CommonConditions {
    private WebDriver driver = DriverSingleton.getDriver();
    //private Service service = new Service();
    private CalculatorModel calculatorModel = CalculatorCreator.withCredentialsFromProperty();
    private Double estimationPageCost;

    @Test
    public void openPage() throws IOException, UnsupportedFlavorException {
        CalculatorPage calculatorPage = new HomePage(driver)
                .openPage()
                .returnSearchResult("Google Cloud Platform Pricing Calculator")
                .openCalculator()
                .activateFrame()
                .selectComputeEngine()
                .inputNumberOfInstances(calculatorModel.getNumberOfInstances())
                .inputOS(calculatorModel.getOperatingSystem())
                .inputMachineClass(calculatorModel.getMachineClass())
                .inputSeries(calculatorModel.getSeries())
                .inputMachineType(calculatorModel.getMachineType())
                .inputGPU(calculatorModel.getAddGPU(), calculatorModel.getNumberOfGPUs(), calculatorModel.getGPUtype())
                .inputSSD(calculatorModel.getLocalSSD())
                .inputLocation(calculatorModel.getLocation())
                .inputCommitedUsage(calculatorModel.getCommittedUsage())
                .addToEstimate()
                .openNewTab();
        MailService mailService = new MailService(driver)
                .getToTempMailServiceHomePage()
                .turnTheNightModeOn()
                .copyTemporaryEmail();
    }
}
