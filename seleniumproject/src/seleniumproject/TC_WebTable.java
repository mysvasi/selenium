package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_WebTable {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String Url = "‪D:\\Testing Notes\\webtable";
		driver.get(Url);
		
		//Count Details
		int row = driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr")).size();
		int col = driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr[1]/td")).size();
		int rowcol = driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr/td")).size();
		System.out.println(row);
		System.out.println(col);
		System.out.println(rowcol);
		//To get Data from particular Cell
		String data1 = driver.findElement(By.xpath("//table [@id='idCourse']/tbody/tr[2]/td[2]")).getText();
		System.out.println (data1);
		//To get Data from all rows
		for (int i=1;i<=row;i++) {
		//for (int j=1;j<=col;j++) {
		String data = driver.findElement(By.xpath("//table [@id='idCourse']/tbody/tr["+i+"]")).getText ();
		System.out.println(data);
		}

	}

}
