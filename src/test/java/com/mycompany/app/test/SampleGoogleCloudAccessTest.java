package com.mycompany.app.test;

import com.mycompany.app.page.*;
import org.testng.annotations.Test;

public class SampleGoogleCloudAccessTest extends CommonConditions {
    @Test
    public void launchGoogleCloud() {
        CloudGoogleCalculatorPage cloudGoogleCalculatorPage = new CloudGoogleHomePage(driver)
                .startPage()
                .cloudSearchPage()
                .activateComputeEngine()
                .inputNumberOfInstances()
                .inputOS()
                .inputMachineClass()
                .inputSeries()
                .inputSeriesN1()
                .inputInstanceType()
                .inputGPU()
                .inputSSD()
                .inputLocation()
                .inputCommitedUsage()
                .addToEstimate()
                .emailEstimate()
                .openNewTab();
    }
}
