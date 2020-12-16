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
    //
    @FindBy(xpath = "//input[contains(@ng-model,'quantity')]")
    private WebElement numberOfInstances;
    //
    @FindBy(xpath = "//label[text()='Operating System / Software']/../md-select")
    private WebElement operatingSystem;
    //
    @FindBy(xpath = "//md-option[@value='free']")
    private WebElement optionFreeOS;
    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClass;
    //
    @FindBy(xpath = "//md-select-menu[@style=contains(text(), '')]/descendant::md-option[@value='regular']")
    private WebElement regularMachine;
    //
    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesElement;
    //
    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement seriesN1;
    //
    @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
    private WebElement machineType;
    //
    @FindBy(xpath = "//md-option[@value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]") //doesnt work ~ strange
    private WebElement optionMachineType;
    //
    @FindBy(xpath = "//*[contains(@ng-model,'GPU')]")
    private WebElement addGPU;
    //
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;
    //
    @FindBy(xpath = "//div[normalize-space()='1']/parent::md-option")
    private WebElement inputNumberOfGPU;
    //
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUtype;
    //
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement inputTypeOfGPU;
    //
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSD;
    //
    @FindBy(xpath = "//div[normalize-space()='2x375 GB']/parent::md-option")
    private WebElement typeLocalSSD;
    //
    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement location;
    //
    @FindBy(xpath = "//md-select-menu[@class='md-overflow']/descendant::div[contains(text(), 'Iowa')]/parent::md-option")
    private WebElement typeLocation;
    //
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsage;
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

    public CalculatorPage inputOS() {
        operatingSystem.click();
        optionFreeOS.click();
        return this;
    }

    public CalculatorPage inputMachineClass() {
        click(machineClass);
        click(regularMachine);
        return this;
    }

    public CalculatorPage inputSeries() {
        waitForVisibility(seriesElement);
        seriesElement.click();
        return this;
    }

    public CalculatorPage inputSeriesN1() {
        waitForVisibility(seriesN1);
        seriesN1.click();
        return this;
    }

    public CalculatorPage inputInstanceType() {
        waitForVisibility(machineType);
        machineType.click();
        waitForVisibility(optionMachineType);
        optionMachineType.click();
        return this;
    }

    public CalculatorPage inputGPU() {
        waitForVisibility(addGPU);
        addGPU.click();
        waitForVisibility(numberOfGPUs);
        numberOfGPUs.click();
        waitForVisibility(inputNumberOfGPU);
        inputNumberOfGPU.click();
        click(inputNumberOfGPU);
        waitForVisibility(GPUtype);
        GPUtype.click();
        waitForVisibility(inputTypeOfGPU);
        inputTypeOfGPU.click();
        return this;
    }

    public CalculatorPage inputSSD() {
        waitForVisibility(localSSD);
        localSSD.click();
        waitForVisibility(typeLocalSSD);
        typeLocalSSD.click();
        return this;
    }

    public CalculatorPage inputLocation() {
        waitForVisibility(location);
        location.click();
        waitForVisibility(typeLocation);
        typeLocation.click();
        return this;
    }

    public CalculatorPage inputCommitedUsage() {
        waitForVisibility(committedUsage);
        committedUsage.click();
        waitForVisibility(typeCommittedUsage);
        typeCommittedUsage.click();
        return this;
    }

    public CalculatorPage addToEstimate() {
        waitForVisibility(addToEstimate);
        addToEstimate.click();
        return this;
    }

    public EstimationPage getAnEstimate() {
        waitForVisibility(addToEstimate);
        addToEstimate.click();
        return new EstimationPage(driver);
    }
}
