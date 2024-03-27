package com.selenium.scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownListTest {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.linkText("Sample Forms")).click();
		WebElement predefiendCountries = driver.findElement(By.id("q9"));
		System.out.println(predefiendCountries.isDisplayed());
		System.out.println(predefiendCountries.isEnabled());
		
		Select select = new Select(predefiendCountries);
		System.out.println("First selected option is : " + select.getFirstSelectedOption().getText());
		select.selectByIndex(0); // Select the first item from the pre-defined countries dropdown
		Thread.sleep(1000);
		select.selectByIndex(1);
		Thread.sleep(1000);
		select.selectByIndex(2);
		Thread.sleep(1000);
		select.selectByVisibleText("India");
				
		List<WebElement> options = select.getOptions();
		System.out.println("No of predefined countries are : " + options.size());
		
		System.out.println("Iterating through the predefined countries dropdown items via for each loop..!");
		for (WebElement country : options) {
			if (country.getText().charAt(0)=='A') {
				System.out.println(country.getText());
			}
		}
		
		System.out.println("Iterating through the predefined countries dropdown items via for loop..!");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
		
		System.out.println("Iterating through the predefined countries dropdown items via lambda.!");
		options.forEach(country->System.out.println(country.getText()));
				
		Thread.sleep(4000);
		driver.quit();
		
	}

}
