//package com.mycompany.app.test;
//
//import com.mycompany.app.driver.DriverSingleton;
//import com.mycompany.app.model.CalculatorModel;
//import com.mycompany.app.page.CalculatorPage;
//import com.mycompany.app.page.HomePage;
//import com.mycompany.app.service.CalculatorCreator;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
//
//import java.awt.datatransfer.UnsupportedFlavorException;
//import java.io.IOException;
//
//public class SmokeAccessTest extends CommonConditions {
//    private WebDriver driver = DriverSingleton.getDriver();
//    private CalculatorModel calculatorModel = CalculatorCreator.withCredentialsFromProperty();
//
//    @Test
//    public void openPage() throws IOException, UnsupportedFlavorException {
//        CalculatorPage calculatorPage = new HomePage(driver)
//                .openPage()
//                .returnSearchResult("Google Cloud Platform Pricing Calculator")
//                .openCalculator();
//    }
//}
