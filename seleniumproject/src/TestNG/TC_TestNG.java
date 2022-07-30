package TestNG;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TC_TestNG {
	
	@Test
	public void openFirefoxbrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver\\geckodriver.exe");
		WebDriver driver1 = new FirefoxDriver();
		driver1.manage().window().maximize();
		driver1.manage().deleteAllCookies();
		driver1.get("https://admin-demo.nopcommerce.com/login");		
		driver1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver1.quit();
	}
		
 }


