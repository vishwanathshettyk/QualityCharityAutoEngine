package org.automation.practices.factory;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.automation.practices.utils.DataReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class BaseTest extends PlaywrightFactory {

    public static Map read;

    static Page pages;

    @Before
    public void setup(Scenario scenario) throws IOException {
        page = getPage();
        page.navigate("https://github.com/login");
        pages = page;
        DataReader dataReader = new DataReader();
        read = dataReader.loadData();
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
