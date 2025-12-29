package practice_HRMS;


import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class All_Links_java8Features {
	

	    public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.get("https://www.google.com");

	        // 1️⃣ Get all links
	        List<WebElement> links = driver.findElements(By.tagName("a"));

	        // 2️⃣ Count total links
	        long count = links.stream().count();
	        System.out.println("Total Links: " + count);

	        // 3️⃣ Print link text + href using Streams
	        links.stream()
	             .map(link -> link.getText().isEmpty() ? "NO TEXT" : link.getText())
	             .forEach(System.out::println);

	        // 4️⃣ If you want to print href also:
	        System.out.println("\n--- Link Text + Href ---");
	        links.stream()
	             .forEach(link -> System.out.println(
	                     (link.getText().isEmpty() ? "NO TEXT" : link.getText()) 
	                     + " --> " + link.getAttribute("href")
	             ));

	        driver.quit();
	    }
	}


