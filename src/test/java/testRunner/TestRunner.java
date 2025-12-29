package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "E:\\MyProjects\\Deepak_Task_Cucumber\\src\\test\\resources\\Features\\TC0001_AddToCartProduct.feature", 
				 monochrome = false, 
				 glue = {"stepDefinition" }, 
				 plugin = { "pretty", "html:target/cucumber/report.html",
							"json:target/Cucumber/report.json" })
public class TestRunner {

}
