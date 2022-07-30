package seleniumproject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_Takscreenshot {

	public static void main(String[] args) throws IOException {

		//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver\\geckodriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).clear();
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		// TakeScreenshot as Jpg
		File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File("C:\\selenium\\screenshot.jpg"));

		//File f3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		//FileUtils.copyFile(f3, new File("C:\\selenium\\base64screenshot.jpg"));
		
		// TakeScreenshot as PNG
		File f2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f2, new File("C:\\selenium\\screenshot.png"));
		
		File src1 = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\selenium\\fullpage.png");
		FileUtils.copyFile(src1, dest1);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String filename = ("img\\screenshot.png");
		File dest = new File("img//screenshot.png");
		FileUtils.copyFile(src, dest);
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		
	}

}
