package com.mycompany.app.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractGoogleCloudPage {
    protected WebDriver driver;

    protected abstract AbstractGoogleCloudPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractGoogleCloudPage(WebDriver driver) {
        this.driver = driver;
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
}





















