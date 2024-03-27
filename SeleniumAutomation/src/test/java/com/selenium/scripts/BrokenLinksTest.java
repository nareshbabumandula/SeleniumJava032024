package com.selenium.scripts;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLinksTest {

	static WebDriver driver;
	
	public static void verifyLink(String url) {
		try { 
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection)link.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();
			if(httpURLConnection.getResponseCode()==200) {
				System.out.println(url + "-" + httpURLConnection.getResponseMessage());
			}else {
				System.out.println(url + "-" + httpURLConnection.getResponseMessage() + "-" + "is a broken link");
			}
	
		} catch (Exception e) {
			System.out.println(url + "-" + "is a broken link");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(5000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of links found are : " + links.size());
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			verifyLink(url);
		}
		
		driver.quit();

	}

}
