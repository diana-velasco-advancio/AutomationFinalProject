package FinalProject;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {
                "src/main/java/resources/features"
        },
        glue = "FinalProject/steps",
        plugin = {
                "pretty",
                "html:target/cucumber.html"
        },
        tags = "not @ignore"
)
public class Runner {

}
