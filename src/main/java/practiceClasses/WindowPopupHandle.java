package practiceClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowPopupHandle {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		driver.findElement(By.id("newWindowBtn")).click();
		
		//Single WIndow
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		
		String parentWindowHandle = it.next();
		System.out.println(parentWindowHandle);
		
		String childWindowHandle = it.next();
		System.out.println(childWindowHandle);
		
		driver.switchTo().window(childWindowHandle);
		driver.manage().window().maximize();
		driver.findElement(By.id("firstName")).sendKeys("Kumar");
		driver.close();
		
		driver.switchTo().window(parentWindowHandle);
		String text = driver.findElement(By.id("post-body-1510543359168327704")).getText();
		System.out.println(text);
		
		
	}

}
