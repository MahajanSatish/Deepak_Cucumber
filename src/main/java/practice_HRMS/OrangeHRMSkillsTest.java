package practice_HRMS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class OrangeHRMSkillsTest {

	public static void main(String[] args) throws Exception {

//		  Map<String, Object> prefs = new HashMap<>();
//	        prefs.put("credentials_enable_service", false);           // Disable save password popup
//	        prefs.put("profile.password_manager_enabled", false);      // Disable password manager
//	     
//	        ChromeOptions options = new ChromeOptions();
//	        options.setExperimentalOption("prefs", prefs);
//
//	        // Disable all password/breach notifications
//	        options.addArguments("--disable-features=PasswordManagerUI");
//	        options.addArguments("--disable-features=PasswordLeakDetection");
//	        options.addArguments("--disable-features=PasswordCheck");
//	        options.addArguments("--disable-features=PasswordManagerRedesign");
//	        options.addArguments("--disable-features=AutofillServerCommunication");
//	        options.addArguments("--disable-save-password-bubble");
//
//	        // Disable other Chrome interruptions
//	        options.addArguments("--disable-popup-blocking");
//	        options.addArguments("--disable-notifications");
//	        options.addArguments("--disable-infobars");
//	        options.addArguments("--start-maximized");
//	        options.addArguments("--remote-allow-origins=*");

		// Start Chrome
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("http://127.0.0.1/orangehrm-2.6/login.php");

		driver.findElement(By.name("txtUserName")).sendKeys("nareshit");
		driver.findElement(By.name("txtPassword")).sendKeys("nareshit");
		driver.findElement(By.name("Submit")).click();
		System.out.println("Login Success");
		Thread.sleep(2000);

		// Use Sikuli for handling Windows dialog
        Screen s = new Screen();
        s.click("C:\\Users\\imssm\\OneDrive\\Pictures\\Screenshots\\ClickOk_HRMS.png");
    	Thread.sleep(2000);

		// Move cursor on Admin
		Actions act = new Actions(driver);
		WebElement adminMenu = driver.findElement(By.xpath("//a[@class='l1_link']//span[text()='Admin']"));

		// WebElement adminMenu =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Admin")));
		act.moveToElement(adminMenu).build().perform();
		Thread.sleep(2000);
		System.out.println("Admin Perform");

		// Move cursor on Skills
		// WebElement skills = driver.findElement(By.xpath("//a[@class='l2_link parent
		// skills']"));
		WebElement skills = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='l2_link parent skills']")));
		act.moveToElement(skills).build().perform();

		System.out.println("Skills perform");
		Thread.sleep(2000);

		// Click on Skills
		WebElement skillsMenu = driver.findElement(By.xpath("//a[@class='skills']//span[text()='Skills']"));
//		WebElement skillsMenu = wait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='skills']//span[text()='Skills']")));
		skillsMenu.click();
		System.out.println("Skills Click");

		driver.quit();
	}
}
