package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_JavaScriptExecutor {

	public static void main(String[] args) {
		
		//WebDriver driver = null ;
				
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));	
		driver.findElement(By.id("txtUsername")).clear();
		WebElement username = driver.findElement(By.id("txtUsername"));
		
		//Send the username  using JS
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("document.getElementById(‘txtUsername’).value ='Admin';");	
		//executor.executeScript("document.getElementByXpath(‘//input[@id='txtUsername']’).value ='Admin';");	
		executor.executeScript("arguments[0].value='Admin';", username);
		
		//Send the password using JS
		driver.findElement(By.name("txtPassword")).clear();
		WebElement password = driver.findElement(By.name("txtPassword"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].value='admin123';", password);
		
		//Clicking the button using JS
		WebElement submit = driver.findElement(By.xpath("//input[@id='btnLogin']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", submit);
		
		//To Scroll the page using webelement 
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
		WebElement lastpage = driver.findElement(By.xpath("//a[contains(text(),'user123')]"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].scrollIntoView(true);",lastpage);
		//without webelement to goto bottom of page
		//executor3.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    System.out.println("Page is scolled to last ");
	    
	   // This  will scroll down the page by  1000 pixel vertical	
	    JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-2000)");
        System.out.println("Page is scolled to up ");


	}

}
