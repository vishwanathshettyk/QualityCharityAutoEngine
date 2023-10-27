package org.automation.practices.steps;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.practices.pages.TestPage;

import static org.automation.practices.factory.BaseTest.getPages;

public class TestStep {

    Page page = getPages();
    TestPage testPage = new TestPage(page);

    @Given("I open playwright URL")
    public void i_open_playwright_URL() throws InterruptedException {
        System.out.println("test");
        testPage.goToGetStarted();
    }

    @Then("page {string} is open")
    public void pageIsOpen(String title) {
        System.out.println("Page Title is: " + page.title());
        assertThat(page).hasTitle(title);
    }

    @When("{string} is searched")
    public void isSearched(String searchText) throws InterruptedException {
        testPage.search(searchText);
        Thread.sleep(4000);
    }

    @Then("search results are shown")
    public void searchResultsAreShown() {
    }
}
