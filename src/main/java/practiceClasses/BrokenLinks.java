package practiceClasses;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinks {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("http://www.amazon.in");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		//List<String> urlList =new ArrayList<String>();	
		
		for (WebElement e : links) {
			String url = e.getAttribute("href");
			checkBrokenLink(url);
		}
		
		
		driver.quit();
	}
	
	public static void checkBrokenLink(String linkUrl) {
		
		try {
			
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if (httpUrlConnection.getResponseCode() >=400) {
				System.err.println(linkUrl + "--->" + httpUrlConnection.getResponseMessage() + " is a broken link");
			}
			else {
				System.out.println(linkUrl + "--->" + httpUrlConnection.getResponseMessage());
			}
		} catch (Exception e) {
			
		}
	

	}

}
