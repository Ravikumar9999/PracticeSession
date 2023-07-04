package practiceClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownGetAllOptions {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://register.rediff.com/register/register.php");
		
		driver.findElement(By.cssSelector("#tblcrtac > tbody > tr:nth-child(3) > td:nth-child(3) > input[type=text]")).sendKeys("RK");
		
		driver.findElement(By.className("nomargin")).click();
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
		Select se=new Select(element);
		
		se.selectByValue("09");
		
		//To get all the options present in the dropdown
		List<WebElement> allOptions = se.getOptions();
		for (WebElement webElement : allOptions)
		{
			System.out.println(webElement.getText());
		}
	}

}
