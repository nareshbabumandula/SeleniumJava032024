package com.selenium.scripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindowsTest {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver(); // first window
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		
		WebElement sampleForms = driver.findElement(By.linkText("Sample Forms"));
		String s = Keys.chord(Keys.CONTROL, Keys.RETURN);
		sampleForms.sendKeys(s); // second window
		WebElement features = driver.findElement(By.linkText("Features"));
		sampleForms.sendKeys(s); // third window
		//driver.switchTo().newWindow(WindowType.TAB); // fourth window
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(mainWindow);
		System.out.println(windows);
		
		Iterator<String> iter = windows.iterator();
		
		while (iter.hasNext()) {
			String childWindow = iter.next();
			driver.switchTo().window(childWindow);
			String title = driver.getTitle();
			System.out.println(childWindow);
			if (title.contains("Sample Email Forms")) {
				driver.findElement(By.id("subject")).sendKeys("Test Subject");
				Thread.sleep(3000);
				driver.close();
			}

		}
		driver.switchTo().window(mainWindow);
		driver.findElement(By.name("user")).sendKeys("Praveen");
		Thread.sleep(3000);
		
		driver.quit(); // Closes all the windows opened by webdriver. WebDriver browser session will be terminated completely

	}

}
