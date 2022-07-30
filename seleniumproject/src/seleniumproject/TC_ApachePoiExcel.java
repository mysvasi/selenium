package seleniumproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_ApachePoiExcel {

	public static void main(String[] args) throws IOException {

		//Reading the data from excel using Apache POI
		FileInputStream fis = new FileInputStream("C:\\selenium\\test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		System.out.println(sheet.getSheetName());
		System.out.println(sheet.getLastRowNum());
		XSSFCell firstname = sheet.getRow(1).getCell(0);
		String fn = firstname.toString();
		XSSFCell middletname = sheet.getRow(1).getCell(1);
		String mn = middletname.toString();
		XSSFCell lastname = sheet.getRow(1).getCell(2);
		String ln = lastname.toString();
		XSSFCell empid = sheet.getRow(1).getCell(3);
		String eid = empid.toString();
		System.out.println(firstname);
		System.out.println(middletname);
		System.out.println(lastname);
		System.out.println(empid);
				
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).clear();
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		// Click on Add Employee
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("firstName")).sendKeys(fn);
		driver.findElement(By.id("middleName")).sendKeys(mn);
		driver.findElement(By.id("lastName")).sendKeys(ln);
		driver.findElement(By.id("employeeId")).clear();
		driver.findElement(By.id("employeeId")).sendKeys(eid); 
				
		// Write the data to excel file				
		FileOutputStream fileOut=new FileOutputStream("C:\\selenium\\test.xlsx");
		XSSFCell cell = sheet.getRow(1).createCell(4);				
		cell.setCellValue("PASS");		
		workbook.write(fileOut);
		System.out.println("Updated data after write is done " + cell.getStringCellValue());
		fileOut.close();
		workbook.close();
		

	}

}
