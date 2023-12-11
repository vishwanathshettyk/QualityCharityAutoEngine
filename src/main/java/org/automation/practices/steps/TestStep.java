package org.automation.practices.steps;

import com.esotericsoftware.yamlbeans.YamlException;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.practices.factory.BaseTest;
import org.automation.practices.pages.BasePage;
import org.automation.practices.pages.TestPage;
import org.automation.practices.utils.ControllersList;
import org.automation.practices.utils.DataReader;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.automation.practices.factory.BaseTest.getPages;
import static org.automation.practices.factory.BaseTest.read;

public class TestStep extends ControllersList {

    BasePage basePage = new BasePage();
    Page page = getPages();
    TestPage testPage;
   // Map<Object> dataObjects;
    Map data = BaseTest.read;

    Map pageObjects;
    public TestStep() throws IOException {
    }

    public void invokePage(String methodName, String... arg ) throws InstantiationException, IllegalAccessException {
        BasePage basePage = new BasePage();
        Object obj = basePage.initPage(TestPage.class);
        basePage.getInstanceOfPage(obj,methodName,arg);
    }
    public void getInstanceOfPage(String methodName, String... arg) {
        TestPage testPage = new TestPage();
        try {
            Class obj = testPage.getClass();
            Method[] methods = obj.getDeclaredMethods();
            for (Method method : methods) {
                if (methodName.equalsIgnoreCase(method.getName())) {
                    method.invoke(testPage, arg);
                }
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Throwable t = e.getCause();
            System.out.println(t.getMessage());
            String fx = e.getMessage();

            e.printStackTrace();
            Assert.fail(String.format("Method '%s' or locator not found",methodName));
           // throw new RuntimeException();
        }
    }

    @Given("I open playwright URL")
    public void i_open_playwright_URL() throws InterruptedException, InvocationTargetException, IllegalAccessException {
        System.out.println("test");
        //     this.getInstanceOfPage("getMet")
        this.getInstanceOfPage("goToGetStarted");
        //   testPage.goToGetStarted();
    }

    @Then("page {string} is open")
    public void pageIsOpen(String title) {
        System.out.println("Page Title is: " + page.title());
        assertThat(page).hasTitle(title);
    }

    @When("{string} is searched")
    public void isSearched(String searchText) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        this.getInstanceOfPage("search", searchText);
        Thread.sleep(4000);
    }

    @Then("search results are shown")
    public void searchResultsAreShown() {
    }

    @Given("^([^\"]*) Page is opened$")
    public void pageIsOpened(String methodName) throws InvocationTargetException, IllegalAccessException {
        this.getInstanceOfPage(methodName);
    }

    @When("^([^\"]*) is searched in ([^\"]*) box$")
    public void isSearchedInBox(String textToFill, String methodName) throws InvocationTargetException, IllegalAccessException {
        this.getInstanceOfPage(methodName, textToFill);
    }

    @Given("^Agent ([^\"]*) username as ([^\"]*)$")
    public void agentEntersUsername(String input,String value) throws InvocationTargetException, IllegalAccessException, IOException {
        System.out.println(data.get(value));
        String processController = getController(input);
        this.getInstanceOfPage(processController);
    }

    @And("^([^\"]*) on ([^\"]*) (button|link)")
    public void clicksOnWriting_testLink(String methodName, String key, String arg) throws IOException {
        String obj = (String) pageObjects.get(key);
        String processController = getController(methodName);
        this.getInstanceOfPage(processController,obj);
    }

    @And("wait for {int} seconds")
    public void waitForSeconds(int seconds) throws InvocationTargetException, IllegalAccessException {
        int millis = seconds * 1000;
        this.getInstanceOfPage("wait", String.valueOf(millis));
    }

    @Then("^([^\"]*) page is opened$")
    public void pageIssOpened(String pageName) throws YamlException, FileNotFoundException, IllegalAccessException, InstantiationException {
        pageObjects = (Map) data.get(pageName.toLowerCase());
        Object obj = pageObjects.get("finder");
        this.invokePage("onPage",obj.toString());
    }

    @Given("test data for test_page is loaded")
    public void testDataForTest_pageIsLoaded() {
    }

    /**
     * "fill" is the method in the page class to invoke.
     * @param textToFill - this is the text which we need to fill
     * @param key - this is the key of web element which we need retrieve from YML file.
     */
    @And("^fill \"([^\"]*)?\" in ([^\"]*) box$")
    public void fillInBox(String textToFill, String key ) {
        String element = (String) pageObjects.get(key);
        this.getInstanceOfPage("fill",element,textToFill);
    }

    @When("^fill ([^\"]*) in ([^\"]*) page$")
    public void fillInLoginPage(String value, String key) {
        {
            String element = (String) pageObjects.get(key);
            this.getInstanceOfPage("fill",element,value);
        }
    }
}
