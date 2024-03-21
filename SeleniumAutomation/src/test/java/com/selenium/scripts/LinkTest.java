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

public class LinkTest {

	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Test
	public void linkMethods() {
		boolean sampleFormsFlag = false;
		String exceptionMsg = "";
		try {
			//sampleFormsFlag = driver.findElement(By.linkText("Sample Forms")).isDisplayed();
			sampleFormsFlag = driver.findElement(By.partialLinkText("Sample")).isDisplayed();
			//WebElement sampleForms = driver.findElement(By.linkText("Sample Forms"));
			WebElement sampleForms = driver.findElement(By.partialLinkText("Sample"));
			
			System.out.println(sampleForms.isDisplayed());
			System.out.println(sampleForms.isEnabled());
			System.out.println(sampleForms.getAttribute("href"));
			System.out.println(sampleForms.getText());
			sampleForms.click();
		} catch (Exception e) {
			exceptionMsg = e.getMessage();
			test.log(LogStatus.FAIL, "Sample Forms tab is not displayed since : " + exceptionMsg);
			e.printStackTrace();
			Assert.assertEquals(sampleFormsFlag, true, "Sample Forms is not displayed since : " + exceptionMsg);
		}finally {
			if (sampleFormsFlag) {
				test.log(LogStatus.PASS, "Successfully verified the Sample Forms tab..!");
			}
		}
	}

	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
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
