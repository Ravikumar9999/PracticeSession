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

public class BrokenImages {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("http://www.amazon.in");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		
		List<String> imgList =new ArrayList<String>();	
		
		for (WebElement e : images) {
			String img = e.getAttribute("src");
			checkBrokenLink(img);
		}
		
		
		driver.quit();
	}
	
	public static void checkBrokenLink(String imgUrl) {
		
		try {
			
			URL url = new URL(imgUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if (httpUrlConnection.getResponseCode() >=400) {
				System.err.println(imgUrl + "------->" + httpUrlConnection.getResponseMessage() + " is a broken link");
			}
			else {
				System.out.println(imgUrl + "------->" + httpUrlConnection.getResponseMessage());
			}
		} catch (Exception e) {
			
		}
	

	}

}
