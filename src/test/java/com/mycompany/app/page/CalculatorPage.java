package com.mycompany.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends AbstractGoogleCloudPage {
    protected CalculatorPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngine;
    @FindBy(xpath = "//input[contains(@ng-model,'quantity')]")
    private WebElement numberOfInstances;

    public CalculatorPage activateFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        return this;
    }

    public CalculatorPage selectComputeEngine() {
        waitForVisibility(computeEngine);
        computeEngine.click();
        return this;
    }

    public CalculatorPage inputNumberOfInstances() {
        waitForVisibility(numberOfInstances);
        numberOfInstances.sendKeys("4");
        return this;
    }
}
