package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ButtonTest {

	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	
	@Test
	public void buttonMethods() {
		boolean bFlag = false;
		String exceptionMsg = "";
		try {
			driver.findElement(By.name("q")).sendKeys("iphone");
			driver.findElement(By.xpath("//button[@aria-label='Search for Products, Brands and More']")).click();
			bFlag=true;
		} catch (Exception e) {
			exceptionMsg = e.getMessage();
			test.log(LogStatus.FAIL, "Search button is not displayed since : " + exceptionMsg);
			e.printStackTrace();
			Assert.assertEquals(bFlag, true, "Search button is not displayed since : " + exceptionMsg);
		}finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Successfully clicked on search button..!");
			}
		}
	}

	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		// Extent Reports
		report = new ExtentReports("./target/ExtentReport/ExtentResults.html");
		test = report.startTest("TC01");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}


}
