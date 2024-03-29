package com.selenium.scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;

import com.utility.Utility;

public class BrowserTest {
	static Utility utility;
	
	static WebDriver driver;
	
	public static void browserMethods(String browser, String url) throws InterruptedException {

		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox": case "ff":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser");;
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.findElement(By.id("user")).sendKeys("Saikrishna");
		driver.findElement(By.id("pass")).sendKeys("Secure*123");

		WebElement username = driver.findElement(By.id("user"));
		System.out.println(username.isDisplayed());
		System.out.println(username.isEnabled());
		System.out.println(username.isSelected());

		username.clear();
		username.sendKeys("Sumithra");

		List<WebElement> elements = driver.findElements(By.xpath("//input[@class='txt_log']"));
		System.out.println("No of elements found are : " + elements.size());

		for (WebElement textfield : elements) {
			System.out.println(textfield.getAttribute("name"));
			System.out.println(textfield.getAttribute("type"));
		}

		System.out.println(driver.getPageSource());

		Thread.sleep(3000);
		driver.quit();
	}


	public static void main(String[] args) throws InterruptedException {
		browserMethods(utility.readProperty("browserType"),utility.readProperty("url"));
	}

}
