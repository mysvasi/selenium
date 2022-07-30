package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class TC_Verify {

	public static void main(String[] args) {
			
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://admin-demo.nopcommerce.com/login");
		// driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		String title = driver.getTitle();
		System.out.println(title);
		Assert.isTrue(true, title, "Your store. Login");
		if (driver.getTitle().equals("Your store. Login")) {
			System.out.println(title + ":" + "title is matched");
		} else {
			System.out.println("title is not matched" + driver.getTitle());
			driver.quit();
		}
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.name("Password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
