//Example to perform keyboard activities using WebDriver and Auto Complete Feature

package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_KeysClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		// driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));	
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys(Keys.ARROW_DOWN);
		System.out.println("First time down arrow key  pressed");
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys(Keys.ARROW_DOWN);
		System.out.println("Second time down arrow key  pressed");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.println("clicked on Enter btn");

	}

}
