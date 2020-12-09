package com.mycompany.app.page;

import com.mycompany.app.page.CloudGoogleCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CloudGoogleSearchPage extends AbstractPage {
    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    List<WebElement> searchResults;

    public CloudGoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleCalculatorPage cloudSearchPage() {
        searchResults.get(0).click();
        return new CloudGoogleCalculatorPage(driver);
    }
}
