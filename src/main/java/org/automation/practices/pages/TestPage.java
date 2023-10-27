package org.automation.practices.pages;

import com.microsoft.playwright.Page;

public class TestPage {

    private final String GET_STARTED_LOCATOR = ".getStarted_Sjon";
    private final String SEARCH_BOX = "#docsearch-input";
    private final String SEARCH_BUTTON = ".DocSearch-Button-Container";
    Page page;

    public TestPage(Page page) {
        this.page = page;
    }

    public void goToGetStarted() {
        page.click(GET_STARTED_LOCATOR);
    }

    public void search(String value) {
        page.click(SEARCH_BUTTON);
        page.fill(SEARCH_BOX, value);
    }
}
