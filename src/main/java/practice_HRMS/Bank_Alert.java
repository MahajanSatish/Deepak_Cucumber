package practice_HRMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bank_Alert {
	
	public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://ctcorphyd.com/EBanking_build1/admin.php");

        driver.findElement(By.xpath("//a[text()='Admin']")).click();
        driver.findElement(By.name("uid")).sendKeys("admin");

        // Click Login button
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        //Capture HTML5 validation message from password field
        String msg_pwd = driver.findElement(By.name("password")).getAttribute("validationMessage");
        System.out.println("Validation Message: " + msg_pwd);

        // Enter password
        driver.findElement(By.name("password")).sendKeys("admin");

        // Click Login again
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}


