package com.mycompany.app.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public abstract class AbstractGoogleCloudPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractGoogleCloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForInvisibility(WebElement element) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitUntilClickable(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(WebElement element) {
        waitForVisibility(element);
        element.sendKeys(Keys.ENTER);
    }

    public void waitAndClick(WebElement element) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public WebElement waitAndClickByOptions(String locator, String value) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator, value))));
    }
}





















