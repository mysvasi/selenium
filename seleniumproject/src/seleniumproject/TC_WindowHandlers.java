package seleniumproject;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_WindowHandlers {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
		String handles = driver.getWindowHandle();
		System.out.println("Current Window Handle: " + handles + "\n");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.linkText("Visit W3Schools.com!")).click();		
		//It holds the number windowhandles
		//Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("No. of tabs "+ windowHandles.size());
		driver.switchTo().window(windowHandles.get(1));

	}

}
