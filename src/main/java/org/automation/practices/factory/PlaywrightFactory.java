package org.automation.practices.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    Browser browser;
    Playwright playwright;
    BrowserContext browserContext;
    public Page page;

    public Page getPage() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();
        return this.page;
    }
}
