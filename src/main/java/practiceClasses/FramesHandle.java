package practiceClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FramesHandle {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("name")).sendKeys("Ravi Kumar");
		
		driver.switchTo().frame("frm1");
		
		Select select = new Select(driver.findElement(By.id("course")));
		select.selectByVisibleText("Java");
		
		driver.switchTo().defaultContent();

		driver.switchTo().frame("frm2");
		
		driver.findElement(By.id("firstName")).sendKeys("RKumar");
	}

}
