package practiceClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);
		  
		Actions action = new Actions(driver);
		
		//1
		WebElement dragSrc = driver.findElement(By.id("draggable"));
		WebElement dropSrc = driver.findElement(By.id("droppable"));
		action.clickAndHold(dragSrc);
		action.moveToElement(dropSrc).release().build().perform();
		
		//2.
		action.clickAndHold(driver.findElement(By.id("draggable")));
		action.moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();
		

	}

}
