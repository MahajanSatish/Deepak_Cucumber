package practice_HRMS;

import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	

	    public static void main(String[] args) throws Exception {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.get("https://www.google.com");
//	        driver.get("https://ctcorphyd.com/SureshIT/index.php");
//	        
//	    	driver.findElement(By.name("txtUserName")).sendKeys("sureshit");
//			driver.findElement(By.name("txtPassword")).sendKeys("sureshit");
//			driver.findElement(By.name("Submit")).click();

	        // Folder path
	        String folderPath = "E:\\MyProjects\\Deepak_Task_Cucumber\\BrokenLinks_ExcelReport";

	        // Create folder if not exists
	        new File(folderPath).mkdirs();

	        // FINAL EXCEL OUTPUT FILE PATH
	        String excelPath = folderPath + "\\Broken_Links_Report.xlsx";

	        // Create NEW workbook (do NOT pass path here)
	        Workbook wb = new XSSFWorkbook();
	        Sheet sheet = wb.createSheet("Broken Links Report");

	        // Header row
	        Row header = sheet.createRow(0);
	        header.createCell(0).setCellValue("Link Text");
	        header.createCell(1).setCellValue("URL");
	        header.createCell(2).setCellValue("Status Code");
	        header.createCell(3).setCellValue("Status Message");

	        // Get all valid href links
	        List<WebElement> links = driver.findElements(By.tagName("a"))
	        		
	        		.stream()
	                .filter(e -> e.getAttribute("href") != null && !e.getAttribute("href").isEmpty())
	                .collect(Collectors.toList());
	              
	        System.out.println("Total Links: " + links.size());
	        int rowIndex = 1;

	        // Verify each link and write to Excel
	        for (WebElement link : links) {
	            String linkText = link.getText().trim();
	            String url = link.getAttribute("href");
	           
	            int responseCode = 0;
	            String message = "";

	            try {
	                HttpURLConnection http = (HttpURLConnection) new URL(url).openConnection();
	                http.setRequestMethod("GET");
	                http.setConnectTimeout(5000);
	                http.connect();

	                responseCode = http.getResponseCode();
	                message = (responseCode >= 400) ? "BROKEN" : "VALID";

	                System.out.println(url + " --> " + message + " (" + responseCode + ")");

	                
	            } catch (Exception e) {
	                message = "ERROR";
	            }
	            	            
	            System.out.println("Total Links:" +links.size());
	            
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(linkText.isEmpty() ? "NO TEXT" : linkText);
	            row.createCell(1).setCellValue(url);
	            row.createCell(2).setCellValue(responseCode);
	            row.createCell(3).setCellValue(message);
	        }

	        // Auto-size columns
	        for (int i = 0; i < 4; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // SAVE the Excel file properly
	        FileOutputStream fos = new FileOutputStream(excelPath);
	        wb.write(fos);
	        fos.close();
	        wb.close();

	        System.out.println("Excel Report Generated at: " + excelPath);

	        driver.quit();
	    }
	}
