package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_Fileupload {
	
	public static void main(String[] args) {
		
		WebDriver driver ;
		//WebDriverWait wait;
		
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
			
		//Explicit Wait for element to be clickable		
		//WebDriverWait wait = new WebDriverWait(driver, 15);// supports from selenium 3.0 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // supports from selenium 4.0 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnLogin']")));					
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //Selenium 3.0
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // Selenium 4.0
		System.out.println("Login completed");
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		WebElement fileupload = driver.findElement(By.xpath("//input[@id='photofile']"));
		fileupload.sendKeys("C:\\Users\\Vasantha.Kumar\\OneDrive - Marlabs Inc\\Documents\\GovardhanaReddyR.jpg");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		System.out.println("Image file is uploaded successfully");		
	}


}
