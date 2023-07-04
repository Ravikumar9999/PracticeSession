package practiceClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://register.rediff.com/register/register.php");
		
		driver.findElement(By.cssSelector("#tblcrtac > tbody > tr:nth-child(3) > td:nth-child(3) > input[type=text]")).sendKeys("Ravi Kumar");
		
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("mohini.ravikumar");
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]")).click();
		
		driver.findElement(By.id("newpasswd")).sendKeys("Ravikumar@9999");
		driver.findElement(By.id("newpasswd1")).sendKeys("Ravikumar@9999");
		
		driver.findElement(By.xpath("//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input")).sendKeys("mohini.ravikumar@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).click();
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[3]/select")));
		select.selectByIndex(3);
		driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).sendKeys("Biryani");
		
		driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).sendKeys("Mohini");
		
		
		driver.findElement(By.id("mobno")).sendKeys("8886688213");
		
		
		
		Select selectDay = new Select (driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]")));
		selectDay.selectByVisibleText("09");
		
		Select selectMonth = new Select (driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]")));
		selectMonth.selectByValue("08");
		
		Select selectYear = new Select (driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]")));
		selectYear.selectByVisibleText("1999");
		
		Select selectCounrty = new Select (driver.findElement(By.id("country")));
		selectCounrty.selectByVisibleText("India");
		
		Select selectCity = new Select (driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select")));
		selectCity.selectByVisibleText("Hyderabad");
		
		
		driver.findElement(By.id("Register")).click();
		
		Thread.sleep(3000);
		
		Alert alert =driver.switchTo().alert();
		System.out.println(alert.getText());
		
		String text = alert.getText();
		
		if(text.equals("ID cannot be blank, please enter your desired ID")) {
			System.out.println("correct alert");
		}else {
			System.err.println("incorrect alert");
		}
		
		alert.accept();
	}

}
