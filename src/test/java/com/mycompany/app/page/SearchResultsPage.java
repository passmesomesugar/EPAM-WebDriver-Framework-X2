package com.mycompany.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractGoogleCloudPage {
    @FindBy(xpath = "//div[@class=\"gs-title\"]/a[@href=\"https://cloud.google.com/products/calculator\"]")
    private WebElement requiredSearchResult;

    protected SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage openCalculator() {
        waitForVisibility(requiredSearchResult);
        click(requiredSearchResult);
        return new CalculatorPage(driver);
    }
}
