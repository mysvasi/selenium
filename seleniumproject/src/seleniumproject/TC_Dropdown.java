package seleniumproject;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_Dropdown {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		// driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element = driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//p//select"));
		Select dropdown = new Select(element);
		dropdown.selectByValue("ALA");
		Thread.sleep(2000);
		dropdown.selectByVisibleText("Zambia");
		Thread.sleep(2000);
		dropdown.selectByIndex(0);
		Thread.sleep(2000);		
		System.out.println(dropdown.getAllSelectedOptions());
	}

}
