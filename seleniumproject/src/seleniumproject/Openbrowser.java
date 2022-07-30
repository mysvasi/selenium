package seleniumproject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Openbrowser {
	
	public WebDriver driver;

	public void openChromebrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://admin-demo.nopcommerce.com/login");
		// driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.quit();
	}

	public static void openFirefoxbrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver\\geckodriver.exe");
		WebDriver driver1 = new FirefoxDriver();
		driver1.manage().window().maximize();
		driver1.manage().deleteAllCookies();
		driver1.get("https://admin-demo.nopcommerce.com/login");		
		driver1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver1.quit();

	}
	
	public static void withoutDownloadDriver() {		
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver2 = new ChromeDriver();
		  driver2.manage().window().maximize();
		  driver2.manage().deleteAllCookies();
		  driver2.get("https://admin-demo.nopcommerce.com/login");		
		  driver2.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		  driver2.quit();	
				
	}
	public static void main(String[] args) {
		 Openbrowser open = new Openbrowser();
		 open.openChromebrowser();		
		 Openbrowser.openFirefoxbrowser();
		 Openbrowser.withoutDownloadDriver();
		

	}

}
