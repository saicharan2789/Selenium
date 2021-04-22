package Runner;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*Assertions done in such a way that only the test cases with correct username and password- which is able to 
login the application will pass the test; rest of them will fail and you can check them in the reports generated in the target folder.
*/
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"feature.feature"},
		glue = {"StepDefinition"},
		plugin = {"html:target/cucumber-reports/cucumber.html"}
		)

public class RunnerClass {
	
}
