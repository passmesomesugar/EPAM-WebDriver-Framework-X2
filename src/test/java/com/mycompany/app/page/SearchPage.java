package com.mycompany.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends AbstractGoogleCloudPage {
    protected SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected AbstractGoogleCloudPage openPage() {
        return null;
    }
}
