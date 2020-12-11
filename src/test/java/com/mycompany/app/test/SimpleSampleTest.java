package com.mycompany.app.test;

import com.mycompany.app.page.HomePage;
import com.mycompany.app.page.SearchPage;
import org.testng.annotations.Test;

public class SimpleSampleTest extends CommonConditions {
    @Test
    public void simpleTestForSearchPage() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        String request = "Google Cloud Platform Pricing Calculator";
        SearchPage searchPage = homePage.returnSearchResult(request);

    }
}
