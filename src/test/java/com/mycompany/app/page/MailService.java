package com.mycompany.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailService extends AbstractGoogleCloudPage {
    protected MailService(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='email']")
    private WebElement copyTemporaryEmailAddress;
    //
    @FindBy(xpath = "//*[@id='color']")
    private WebElement nightMode;
    //
    @FindBy(xpath = "//div[contains(text(), \"Google Cloud Sales\")]")
    private WebElement letterFromCalculator;
    //
    @FindBy(xpath = "*//h3[contains(text(), 'USD')]")
    private WebElement priceInReceivedEmailElement;
    //
    @FindBy(xpath = "//iframe")
    private WebElement iFrame;
    //
    @FindBy(xpath = "//table//h3[contains(text(),\"USD\")]")
    private WebElement totalEstimatedCost;
}
