package com.mycompany.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MailService extends AbstractGoogleCloudPage {
    public MailService(WebDriver driver) {
        super(driver);
    }

    public static Double priceInReceivedEMail;
    //
    @FindBy(xpath = "//*[@id='address']")
    private WebElement copyTemporaryEmailAddressButtonWebElement;
    //
    @FindBy(xpath = "//*[@id='color']")
    private WebElement nightMode;
    //
    @FindBy(xpath = "//div[contains(text(), \"Google Cloud Sales\")]")
    private WebElement letterFromCalculator;
    //
    @FindBy(xpath = "//table//h3[contains(text(),\"USD\")]")
    private WebElement totalEstimatedCostPerMonth;
    //
    @FindBy(xpath = "//iframe")
    private WebElement iFrame;
    //
    @FindBy(xpath = "//table//h3[contains(text(),\"USD\")]")
    private WebElement totalEstimatedCost;

    public MailService getToTempMailServiceHomePage() {
        driver.get("https://mail.tm/ru");
        return this;
    }

    public MailService turnTheNightModeOn() {
        waitAndClick(nightMode);
        return this;
    }

    public MailService copyTemporaryEmail() throws IOException, UnsupportedFlavorException {
        String clipboardString;
        do {
            copyTemporaryEmailAddressButtonWebElement.click();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            clipboardString = (String) clipboard.getData(DataFlavor.stringFlavor);
        } while (!(clipboardString.contains("@")));
        return this;
    }

    public MailService openLetter() {
        waitAndClick(letterFromCalculator);
        return this;
    }

    public void getPriceInReceivedEMail() {
        waitForVisibility(iFrame);
        driver.switchTo().frame(0);
        waitForVisibility(totalEstimatedCostPerMonth);
        priceInReceivedEMail = Double.parseDouble(totalEstimatedCostPerMonth
                .getText().replaceAll("[^0-9.]", ""));
    }
}
