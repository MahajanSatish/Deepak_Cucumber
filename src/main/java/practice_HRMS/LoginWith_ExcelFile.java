package practice_HRMS;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.Duration;



// read the data from xl sheet ,& just create a column for pass and fail 

public class LoginWith_ExcelFile {

	public static void main(String[] args) throws Exception {

		String excelPath = "E:\\MyProjects\\Deepak_Task_Cucumber\\BrokenLinks_ExcelReport\\LoginData.xlsx";

		// Load Excel File
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);

		// Cell styles for PASS / FAIL colors
		CellStyle passStyle = wb.createCellStyle();
		passStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		passStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		CellStyle failStyle = wb.createCellStyle();
		failStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		failStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {

			Row row = sheet.getRow(i);
			String username = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();

			driver.get("https://ctcorphyd.com/SureshIT/login.php");

			driver.findElement(By.name("txtUserName")).sendKeys(username);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			driver.findElement(By.name("Submit")).click();

//	        	// Use Sikuli for handling Windows dialog
//	            Screen s = new Screen();
//	            s.click("C:\\Users\\imssm\\OneDrive\\Pictures\\Screenshots\\ClickOk_HRMS.png");
//	        	Thread.sleep(2000);
//	            
			boolean isPass = false;

			try {
				driver.findElement(By.linkText("Logout"));
				isPass = true; // found Logout → Logout success
			} catch (Exception e) {
				isPass = false; // Logout not found → Logout failed
			}

			// Write PASS/FAIL into Excel
			Cell resultCell = row.createCell(2);
			resultCell.setCellValue(isPass ? "PASS" : "FAIL");
			resultCell.setCellStyle(isPass ? passStyle : failStyle);

			// If FAIL → Take screenshot
			if (!isPass) {
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String screenshotPath = "E:\\MyProjects\\Login_Test\\Screenshots\\Fail_" + i + ".png";
				new File("E:\\MyProjects\\Login_Test\\Screenshots").mkdirs();
				File dest = new File(screenshotPath);
				src.renameTo(dest);

				// Write screenshot path in Excel
				row.createCell(3).setCellValue(screenshotPath);
			}

			System.out.println(username + " | " + password + " => " + (isPass ? "PASS" : "FAIL"));
		}

		fis.close();

		// Save Excel back
		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);
		fos.close();
		wb.close();

		driver.quit();

		System.out.println("\n✔ Test Finished — Excel Updated with Colors + Screenshots");
	}
}
