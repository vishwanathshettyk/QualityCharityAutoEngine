package org.automation.practices.factory;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseTest extends PlaywrightFactory {

    static Page pages;

    @Before
    public void setup(Scenario scenario)
    {
        page = getPage();
        page.navigate("https://playwright.dev/");
        pages = page;
    }

    public static Page getPages()
    {
     return pages;
    }

    @After
    public void tearDown()
    {
        page.close();
    }
}
