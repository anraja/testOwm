package options;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by anra1 on 18/01/18.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/Reports"},
        glue = {"stepdefs"},
        features = {"src/test/features/"})
public class CucumberTest {
}
