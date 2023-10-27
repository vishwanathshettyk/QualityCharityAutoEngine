package org.automation.practices;

import io.cucumber.core.cli.*;

public class RunCucumber {
    private final String GLUE = "--glue";
    private final String GLUE_PATH = "org.automation.practices";
    private final String PLUGIN = "-p";
    private final String PLUGIN_HTML = "html:target/cucumberCli.html";
    private final String FEATURE_PATH = "src/test/resources";

    public static void main(String[] args) {
        RunCucumber app = new RunCucumber();
        app.runCucumberTests();
    }

    public void runCucumberTests() {
        Main.main(GLUE, GLUE_PATH, FEATURE_PATH, PLUGIN, PLUGIN_HTML);
    }
}
