package cucumber.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",glue = {"stepdefinition"},tags = "@AddPlace", plugin = "json:target/jsonReports/cucumber-report.json")
public class TestRunner {
}
//commit to be edited
