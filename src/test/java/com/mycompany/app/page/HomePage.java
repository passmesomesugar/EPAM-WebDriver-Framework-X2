package com.mycompany.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractGoogleCloudPage {
    private final String BASE_URL = "https://cloud.google.com/";
    @FindBy(xpath = "//input[@name='q']")
    WebElement searchBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        driver.navigate().to(BASE_URL);
        log.info("HomePage: openPage execution");
        return this;
    }

    public SearchResultsPage returnSearchResult(String request) {
        waitAndClick(searchBar);
        searchBar.sendKeys(request);
        click(searchBar);
        log.info("SearchResultsPage: returnSearchResult execution");
        return new SearchResultsPage(driver);
    }
}
