package practice_HRMS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class AddEMP_PIM {
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

		driver.get("https://ctcorphyd.com/SureshIT/login.php");

		driver.findElement(By.name("txtUserName")).sendKeys("sureshit");
		driver.findElement(By.name("txtPassword")).sendKeys("sureshit");
		driver.findElement(By.name("Submit")).click();
		System.out.println("Login Success");
		Thread.sleep(2000);

		// Use Sikuli for handling Windows dialog
      Screen s = new Screen();
      s.click("C:\\Users\\imssm\\OneDrive\\Pictures\\Screenshots\\ClickOk_HRMS.png");
  	Thread.sleep(2000);

		// Move cursor on Admin
		Actions act = new Actions(driver);
		WebElement PIM = driver.findElement(By.xpath("//a[@class='l1_link']//span[text()='PIM']"));

		// WebElement adminMenu =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Admin")));
		act.moveToElement(PIM).build().perform();
		Thread.sleep(2000);
		System.out.println("PIM Perform");

		// Move cursor on Skills
		// WebElement skills = driver.findElement(By.xpath("//a[@class='l2_link parent
		// skills']"));
//		WebElement addEmp = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Add Employee']")));
//		act.moveToElement(addEmp).build().perform();
//
//		System.out.println("Add EMP perform");
//		Thread.sleep(2000);

		// Click on Skills
		WebElement addEMP = driver.findElement(By.xpath("//span[normalize-space()='Add Employee']"));
//		WebElement skillsMenu = wait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='skills']//span[text()='Skills']")));
		addEMP.click();
		System.out.println("Add Employee Click");
		
		driver.switchTo().frame("rightMenu");
		System.out.println("Enter in frame");
		
		
		driver.findElement(By.name("txtEmpFirstName")).sendKeys("Satish");
		driver.findElement(By.name("txtEmpLastName")).sendKeys("Mahajan");
		driver.findElement(By.xpath("//input[@value='Save'][@id='btnEdit']")).click();
		Thread.sleep(3000);
		System.out.println("Save Successful");
		
		driver.switchTo().defaultContent();

		driver.quit();
	}
}


