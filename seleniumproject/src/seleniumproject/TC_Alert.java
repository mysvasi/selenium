package seleniumproject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_Alert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'alert box:')]")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		//a.dismiss();
		driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();
		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		a.dismiss();
		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]")).click();
		a.sendKeys("Alert test");
		a.accept();
		
	}

}
