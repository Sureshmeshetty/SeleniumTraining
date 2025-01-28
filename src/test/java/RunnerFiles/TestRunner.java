package RunnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/resources/MyFeatureFiles",
        glue = {"StepDefinitions"},
        tags = "@regression",
        plugin="html:target/cucumber-reports/CucumberTestReport.html"
)
public class TestRunner extends AbstractTestNGCucumberTests {}

