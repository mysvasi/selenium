package seleniumproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TC_JXLExcel {

	public static void main(String[] args) throws BiffException, IOException {

		WebDriver driver;

		// Data reading From excel
		FileInputStream f1 = new FileInputStream("C:\\selenium\\testdata1.xls");
		Workbook w1 = Workbook.getWorkbook(f1);
		Sheet s1 = w1.getSheet("Sheet1"); //From SheetName
		//Sheet s1 = w1.getSheet(0) // From SheetIndex value - Start from 0
		System.out.println(s1.getName());
		//int i = 2; // reading data from one particular row
		String FirstName = s1.getCell(0, 2).getContents();
		String MiddleName = s1.getCell(1, 2).getContents();
		String LastName = s1.getCell(2, 2).getContents();
		String EmployeeID = s1.getCell(3, 2).getContents();
		System.out.println(FirstName);
		System.out.println(MiddleName);
		System.out.println(LastName);
		System.out.println(EmployeeID);

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
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
		driver.findElement(By.id("firstName")).sendKeys(FirstName);
		driver.findElement(By.id("middleName")).sendKeys(MiddleName);
		driver.findElement(By.id("lastName")).sendKeys(LastName);
		driver.findElement(By.id("employeeId")).clear();
		driver.findElement(By.id("employeeId")).sendKeys(EmployeeID);

	}

}
