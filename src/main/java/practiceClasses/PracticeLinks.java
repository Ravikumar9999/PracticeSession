package practiceClasses;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PracticeLinks {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.amazon.in");
		
		List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for (WebElement e : links) {
			String link = e.getAttribute("href");
			getLinks(link);
		}
	}
	
	public static void getLinks(String urlLinks) {
		
		try {
			
			URL url = new URL(urlLinks);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();
			
			if(httpURLConnection.getResponseCode() >=400) {
				System.err.println(urlLinks +"-->"+ httpURLConnection.getResponseMessage() + "broken link");
			}else {
				System.out.println(urlLinks +"-->"+ httpURLConnection.getResponseMessage());
				httpURLConnection.disconnect();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
