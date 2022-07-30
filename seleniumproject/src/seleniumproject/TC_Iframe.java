package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Iframe {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://classic.freecrm.com/index.html");
		Thread.sleep(3000);
		// driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.findElement(By.name("username")).sendKeys("mys_vasanth");		
		driver.findElement(By.name("password")).sendKeys("Divya@09");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");  // Entering frame
		//driver.switchTo().frame(1);
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.switchTo().defaultContent();  //Exit frame

	}

}
