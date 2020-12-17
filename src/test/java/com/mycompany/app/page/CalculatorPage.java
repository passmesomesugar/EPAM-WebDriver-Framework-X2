package com.mycompany.app.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class CalculatorPage extends AbstractGoogleCloudPage {
    protected CalculatorPage(WebDriver driver) {
        super(driver);
    }

    static ArrayList<String> tabs;
    public static Double calculatorPagePriceEstimation;
    //
    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngine;
    //
    @FindBy(xpath = "//input[contains(@ng-model,'quantity')]")
    private WebElement numberOfInstances;
    //
    @FindBy(xpath = "//label[text()='Operating System / Software']/../md-select")
    private WebElement operatingSystem;
    private String softwareMDOptions = "//md-option//div[contains(text(), \"%s\")]";
    //
//    @FindBy(xpath = "//md-option[@value='free']")
//    private WebElement optionFreeOS;
    //
    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClassWebElement;
    private String machineClassMDOptions = "//md-select-menu[@style] /descendant::div[contains(text(), \"%s\")]";
    //
    @FindBy(xpath = "//md-select-menu[@style=contains(text(), '')]/descendant::md-option[@value='regular']")
    private WebElement regularMachine;
    //
    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesElement;
    private String seriesMDOptions = "//div[contains(text(),\"%s\")]";
    //
    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement seriesN1;
    //
    @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
    private WebElement machineTypeWebElement;
    private String machineTypeOptions = "//div[contains(text(), \"%s\")]";
    //
    @FindBy(xpath = "//md-option[@value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]") //doesnt work ~ strange
    private WebElement optionMachineType;
    //
    @FindBy(xpath = "//*[contains(@ng-model,'GPU')]")
    private WebElement addGPUWebElement;
    //
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;
    private String numberOfGPUsMdOption = "//md-select-menu[@style]//md-option[@value=\"%s\"]";
    //
    @FindBy(xpath = "//div[normalize-space()='1']/parent::md-option")
    private WebElement inputNumberOfGPU;
    //
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUtype;
    private String GPUtypesDiv = "//div[contains(text(), \"%s\")]";
    //
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement inputTypeOfGPU;
    private String typeOfGPUsDiv = "//div[contains(text(), \"%s\")]";
    //
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSD;
    private String localSSDDiv = "//div[contains(text(), \"%s\")]";
    //
    @FindBy(xpath = "//div[normalize-space()='2x375 GB']/parent::md-option")
    private WebElement typeLocalSSD;
    //
    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement locationWebElement;
    private String locationDiv = "//md-select-menu[@class=\"md-overflow\"]//div[contains(text(), \"%s\")]";
    //
    @FindBy(xpath = "//md-select-menu[@class='md-overflow']/descendant::div[contains(text(), 'Iowa')]/parent::md-option")
    private WebElement typeLocation;
    //
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsage;
    private String commitedUsageMdOption = "//div[@class=\"md-select-menu-container md-active md-clickable\"]//md-option[@ng-value=\"%s\"]";
    //
    @FindBy(xpath = "//md-select-menu[contains(@style, 'transform-origin')]//div[text()='1 Year']/parent::md-option")
    private WebElement typeCommittedUsage;
    //
    @FindBy(xpath = "//*[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimate;
    //
    @FindBy(xpath = "//*[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateElement;
    //
    @FindBy(xpath = "//*[@id='email']")
    private WebElement temporaryEmailCopyAddress;
    //
    @FindBy(xpath = "//*[@id='color']")
    private WebElement nightMode;
    //
    @FindBy(xpath = "//input[@type='email']")
    WebElement buttonInputMail;
    //
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement buttonSendEmail;

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

    public CalculatorPage inputNumberOfInstances(String number) {
        waitForVisibility(numberOfInstances);
        numberOfInstances.sendKeys(number);
        return this;
    }

    public CalculatorPage inputOS(String optionOS) {
        //waitAndClick(operatingSystem);
        //waitForVisibility(operatingSystem);
        click(operatingSystem);
        waitAndClickByOptions(softwareMDOptions, optionOS);
        return this;
    }

    public CalculatorPage inputMachineClass(String machineClass) {
        //waitForVisibility(machineClassWebElement);
        click(machineClassWebElement);
        waitAndClickByOptions(machineClassMDOptions, machineClass).click();
        return this;
    }

    public CalculatorPage inputSeries(String series) {
        waitForVisibility(seriesElement);
        //waitUntilClickable(seriesElement);
        click(seriesElement);
        waitAndClickByOptions(seriesMDOptions, series).click();
        return this;
    }

    public CalculatorPage inputMachineType(String machineType) {
        waitForVisibility(machineTypeWebElement);
        click(machineTypeWebElement);
        waitAndClickByOptions(machineTypeOptions, machineType).click();
//        waitForVisibility(optionMachineType);
//        optionMachineType.click();
        return this;
    }

    public CalculatorPage inputGPU(Boolean addGPU, String numberOfGPUsValue, String typeOfGPUValue) {
        if (addGPU == true) {
            waitForVisibility(addGPUWebElement);
            addGPUWebElement.click();
            click(numberOfGPUs);
            waitAndClickByOptions(numberOfGPUsMdOption, numberOfGPUsValue).click();
            click(GPUtype);
            waitAndClickByOptions(typeOfGPUsDiv, typeOfGPUValue).click();
        }
//        waitForVisibility(numberOfGPUs);
//        numberOfGPUs.click();
//        waitForVisibility(inputNumberOfGPU);
//        inputNumberOfGPU.click();
//        click(inputNumberOfGPU);
//        waitForVisibility(GPUtype);
//        GPUtype.click();
//        waitForVisibility(inputTypeOfGPU);
//        inputTypeOfGPU.click();
        return this;
    }

    public CalculatorPage inputSSD(String SSDValue) {
        waitForVisibility(localSSD);
        localSSD.click();
//        waitForVisibility(typeLocalSSD);
//        typeLocalSSD.click();
        waitAndClickByOptions(localSSDDiv, SSDValue).click();
        return this;
    }

    public CalculatorPage inputLocation(String locationString) {
        waitForVisibility(locationWebElement);
        locationWebElement.click();
        waitAndClickByOptions(locationDiv, locationString).click();
//        waitForVisibility(typeLocation);
//        typeLocation.click();
        return this;
    }

    public CalculatorPage inputCommitedUsage(String usage) {
        waitForVisibility(committedUsage);
        committedUsage.click();
//        waitForVisibility(typeCommittedUsage);
//        typeCommittedUsage.click();
        waitAndClickByOptions(commitedUsageMdOption, usage).click();
        return this;
    }

    public CalculatorPage addToEstimate() {
        waitForVisibility(addToEstimate);
        addToEstimate.click();
        return this;
    }

    public CalculatorPage openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
//    public EstimationPage getAnEstimate() {
//        waitForVisibility(addToEstimate);
//        addToEstimate.click();
//        return new EstimationPage(driver);
//    }
}
