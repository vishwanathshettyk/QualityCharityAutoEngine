package org.automation.practices.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"},
        glue = "org.automation.practices")
public class TestRunner {
}
