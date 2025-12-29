package stepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC001_AddToCart {
	WebDriver driver;

	@Given("Launch the browser")
	public void launch_the_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("Enter the URL {string}")
	public void enter_the_url(String string) {

		driver.navigate().to(string);

	}

	@Then("Select Mobile and add to cart")
	public void select_mobile_and_add_to_cart() throws InterruptedException {
		WebElement phone = driver.findElement(By.xpath("//a[contains(text(),'Samsung galaxy s6')]"));
		phone.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();

		Thread.sleep(2000);
		driver.switchTo().alert().accept();

	}

	@Then("go to home page")
	public void go_to_home_page() {

		driver.findElement(By.id("nava")).click(); // Click on site logo to return to home
		// driver.quit(); // Optional: close browser at the end
	}

}
