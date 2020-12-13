package com.mycompany.app.service;

import com.mycompany.app.driver.DriverSingleton;
import com.mycompany.app.page.CalculatorPage;
import com.mycompany.app.page.HomePage;
import com.mycompany.app.page.SearchResultsPage;
import org.openqa.selenium.WebDriver;

public class Service {
    private WebDriver driver = DriverSingleton.getDriver();
    private CalculatorPage calculatorPage;

    public Service openCloudGoogleCalculatorPage() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        String request = "Google Cloud Platform Pricing Calculator";
        SearchResultsPage searchPage = homePage.returnSearchResult(request);
        calculatorPage = searchPage.openCalculator()
        ;
        return this;
    }

    public Service inputCalculatorData() {
        calculatorPage
                .activateFrame()
                .selectComputeEngine()
                .inputNumberOfInstances();
        return this;
    }
}
