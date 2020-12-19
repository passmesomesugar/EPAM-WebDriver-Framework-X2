package com.mycompany.app.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        log.info("CalculatorPage: activate Frame execution");
        return this;
    }

    public CalculatorPage selectComputeEngine() {
        waitForVisibility(computeEngine);
        computeEngine.click();
        log.info("CalculatorPage: selectComputeEngine execution");
        return this;
    }

    public CalculatorPage inputNumberOfInstances(String number) {
        waitForVisibility(numberOfInstances);
        numberOfInstances.sendKeys(number);
        log.info("CalculatorPage: inputNumberOfInstances execution");
        return this;
    }

    public CalculatorPage inputOS(String optionOS) {
        click(operatingSystem);
        waitAndClickByOptions(softwareMDOptions, optionOS);
        log.info("CalculatorPage: inputOS execution");
        return this;
    }

    public CalculatorPage inputMachineClass(String machineClass) {
        click(machineClassWebElement);
        waitAndClickByOptions(machineClassMDOptions, machineClass).click();
        log.info("CalculatorPage: inputMachineClass execution");
        return this;
    }

    public CalculatorPage inputSeries(String series) {
        waitForVisibility(seriesElement);
        click(seriesElement);
        waitAndClickByOptions(seriesMDOptions, series).click();
        log.info("CalculatorPage: inputSeries execution");
        return this;
    }

    public CalculatorPage inputMachineType(String machineType) {
        waitForVisibility(machineTypeWebElement);
        click(machineTypeWebElement);
        waitAndClickByOptions(machineTypeOptions, machineType).click();
        log.info("CalculatorPage: inputMachineType execution");
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
        log.info("CalculatorPage: inputGPU execution");
        return this;
    }

    public CalculatorPage inputSSD(String SSDValue) {
        waitForVisibility(localSSD);
        localSSD.click();
        waitAndClickByOptions(localSSDDiv, SSDValue).click();
        log.info("CalculatorPage: inputSSD execution");
        return this;
    }

    public CalculatorPage inputLocation(String locationString) {
        waitForVisibility(locationWebElement);
        locationWebElement.click();
        waitAndClickByOptions(locationDiv, locationString).click();
        log.info("CalculatorPage: inputLocation execution");
        return this;
    }

    public CalculatorPage inputCommitedUsage(String usage) {
        waitForVisibility(committedUsage);
        committedUsage.click();
        waitAndClickByOptions(commitedUsageMdOption, usage).click();
        log.info("CalculatorPage: inputCommitedUsage execution");
        return this;
    }

    public CalculatorPage addToEstimate() {
        waitForVisibility(addToEstimate);
        addToEstimate.click();
        log.info("CalculatorPage: addToEstimate execution");
        return this;
    }

    public CalculatorPage emailEstimate() {
        waitForVisibility(emailEstimateElement);
        emailEstimateElement.click();
        waitForVisibility(buttonInputMail);
        log.info("CalculatorPage: emailEstimate execution");
        return this;
    }

    public CalculatorPage openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        log.info("CalculatorPage: openNewTab execution");
        return this;
    }

    public CalculatorPage inputEmailAddress() {
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        buttonInputMail.sendKeys(Keys.CONTROL + "v");
        log.info("CalculatorPage: inputEmailAddress execution");
        return this;
    }

    public CalculatorPage sendEmail() {
        waitAndClick(buttonSendEmail);
        buttonSendEmail.click();
        log.info("CalculatorPage: sendEmail execution");
        return this;
    }

    public CalculatorPage getPriceFromCalculator() {
        WebElement priceCalculator = new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]")));
        String priceString = priceCalculator
                .getText()
                .replace("1 month", "")
                .replaceAll("[^0-9.]", "");
        calculatorPagePriceEstimation = Double.parseDouble(priceString);
        log.info("CalculatorPage: getPriceFromCalculator execution");
        return this;
    }

    public CalculatorPage switchToMailPage() {
        driver.switchTo().window(CalculatorPage.tabs.get(1));
        log.info("CalculatorPage: switchToMailPage execution");
        return this;
    }
}