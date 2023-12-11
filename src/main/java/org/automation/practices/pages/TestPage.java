package org.automation.practices.pages;

import com.microsoft.playwright.Page;
import org.automation.practices.factory.BaseTest;
import org.json.JSONObject;
import org.junit.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestPage {

    private final String GET_STARTED_LOCATOR = ".getStarted_Sjon";
    private final String SEARCH_BOX = "#docsearch-input";
    private final String SEARCH_BUTTON = ".DocSearch-Button-Container";

    Page page = BaseTest.getPages();

    public void getStarted() {
        page.click(GET_STARTED_LOCATOR);
        String href = (String) page.evaluate("document.location.href");

        System.out.println(href);
    }

    public void search(String value) {
        page.click(SEARCH_BUTTON);
        page.fill(SEARCH_BOX, value);
    }

    public void click(String webElement)
    {
        System.out.println(webElement);
        page.locator(webElement).click();
    }

    public void fill(String webElement, String value)
    {
        System.out.println(webElement);
        page.locator(webElement).fill(value);
    }

    public void wait(String timeouts) throws InterruptedException {
        Long sec = Long.parseLong(timeouts);
        Thread.sleep(sec);
       // page.wait(sec);
    }

    public void onPage(String element)
    {
        assertThat(page.locator(element)).isVisible();
    }
}
