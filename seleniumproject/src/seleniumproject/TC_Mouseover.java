// MouseOver and Scrolling

package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_Mouseover {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		String title = driver.getTitle();
		System.out.println(title);
		if (driver.getTitle().equals("OrangeHRM")) {
			System.out.println(title + ":" + "title is matched");
		} else {
			System.out.println("title is not matched" + driver.getTitle());			
		}		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.linkText("PIM"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add Employee")).click();
		System.out.println("Add Employee Page is loaded");
		
		//Scrolling of page 
		driver.findElement(By.linkText("Admin")).click();
		Thread.sleep(2000);
		action.scrollByAmount(100 ,600).perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -600)");	
		
		
		
	}

}
