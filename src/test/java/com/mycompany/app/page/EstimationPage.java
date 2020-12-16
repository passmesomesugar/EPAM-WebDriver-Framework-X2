package com.mycompany.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EstimationPage extends AbstractGoogleCloudPage {
    protected EstimationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//b[contains(text(), \"Total Estimated Cost:\")]")
    private WebElement totalEstimatedCost;

    public Double getTotalEstimation() {
        waitForVisibility(totalEstimatedCost);
        return Double.parseDouble(
                totalEstimatedCost.getText().replace(" 1 ", "")
                        .replaceAll("[^0-9.]", ""));
    }
}
