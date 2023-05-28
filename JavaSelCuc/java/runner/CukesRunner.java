package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json", //this one to connect with jira
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt"

        },

        features ="src/test/resources/features",
        glue ="step_Definitions",
        dryRun=false,
        tags = "@Cert"
)
public class CukesRunner {

}