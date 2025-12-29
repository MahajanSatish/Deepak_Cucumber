package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	WebDriver driver;

	@BeforeClass
	void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider="loginData")
	void testLogin(String email,  String pwd) throws Exception  {

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input [@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if (status == true) 
		{
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		} else
			Assert.fail();
	}

	@DataProvider(name="loginData")  // indices= {0, 1}     when we use i want only 1 and 2 data from data provider.
	Object[][] getLoginData() {
		
		Object Data[][] = {

				{ "abc@gmail.com", "123" }, 
				{ "pqr@gmail.com", "1234" }, 
				{ "xyz@gmail.com", "12345" } };

		return Data;

	}

	@AfterClass
	void tearDown() {

	}
}
