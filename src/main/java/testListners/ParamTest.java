package testListners;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

	WebDriver driver;

	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String br) {
		driver= new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority = 1)
	void testLogo() {
		

	
	}
	
	@Test(priority = 2)
	void testTilte() {
		
	}
	
	@Test(priority = 3)
	void testURL() {
		
	
	}
	@AfterClass
	void tearDown() {
		
		
	}
}
