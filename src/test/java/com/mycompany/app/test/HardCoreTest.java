package com.mycompany.app.test;

import com.mycompany.app.driver.DriverSingleton;
import com.mycompany.app.model.CalculatorModel;
import com.mycompany.app.page.CalculatorPage;
import com.mycompany.app.page.HomePage;
import com.mycompany.app.page.MailService;
import com.mycompany.app.service.CalculatorCreator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class HardCoreTest extends CommonConditions {
    private WebDriver driver = DriverSingleton.getDriver();
    private CalculatorModel calculatorModel = CalculatorCreator.withCredentialsFromProperty();

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
                .emailEstimate()
                .openNewTab();
        MailService mailService = new MailService(driver)
                .getToTempMailServiceHomePage()
                .turnTheNightModeOn()
                .copyTemporaryEmail()
                .switchToCalculator()
                //
                ;
        calculatorPage
                .inputEmailAddress()
                .sendEmail()
                .getPriceFromCalculator()
                .switchToMailPage()
        ;
        mailService
                .openLetter()
                .getPriceInReceivedEMail();
        Assert.assertEquals(CalculatorPage.calculatorPagePriceEstimation, MailService.priceInReceivedEMail, "Prices are equal");
    }

    @Test
    public void checkEqualPrice() {
        Assert.assertEquals(CalculatorPage.calculatorPagePriceEstimation, MailService.priceInReceivedEMail, "Prices are equal");
    }
}
