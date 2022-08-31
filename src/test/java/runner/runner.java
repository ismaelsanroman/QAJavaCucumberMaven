package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// CUCUMBER REPORT
@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/features" }, 
		glue = { "code" }, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
										"json:target/cucumber-reports.json", "pretty" }, 
		tags = "@tag")

public class runner {
}
