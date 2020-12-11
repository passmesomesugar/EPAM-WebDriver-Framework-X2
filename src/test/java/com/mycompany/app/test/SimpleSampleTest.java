package com.mycompany.app.test;

import com.mycompany.app.driver.DriverSingleton;
import com.mycompany.app.page.HomePage;
import com.mycompany.app.page.SearchResultsPage;
import com.mycompany.app.service.Service;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SimpleSampleTest extends CommonConditions {
    private WebDriver driver = DriverSingleton.getDriver();
    private Service service = new Service();

    @Test
    public void openCalc() {
        service.openCloudGoogleCalculatorPage();
//        HomePage homePage = new HomePage(driver);
//        homePage.openPage();
//        String request = "Google Cloud Platform Pricing Calculator";
//        SearchResultsPage searchPage = homePage.returnSearchResult(request);
//        searchPage.openCalculator();
    }
}
