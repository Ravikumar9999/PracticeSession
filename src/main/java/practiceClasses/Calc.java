package practiceClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calc {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		driver.findElement(By.id("newWindowBtn")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		
		String parentWindow = it.next();
		System.out.println(parentWindow);
		
		String childWindow = it.next();
		System.out.println(childWindow);
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());

	}

}
