package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/getADemo.feature",
        glue={"StepDefinitions"},
        plugin ={"pretty", "junit:target/report.xml",
                "json:target/cucumber.json",
                "html:/target/HtmlReports"},
        monochrome = true
        )

public class TestRunner {

}
