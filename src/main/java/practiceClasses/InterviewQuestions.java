package practiceClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InterviewQuestions {

	public static void main(String[] args) {



		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.simplilearn.com/tutorials/selenium-tutorial/selenium-interview-questions-and-answers");
		String text = driver.findElement(By.id("articleLongDescription")).getText();
		System.out.println(text);
	}

}
