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

public class ImageTest {

	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	
	@Test
	public void imageMethods() {
		boolean testimonialFlag = false;
		String exceptionMsg = "";
		try {
			testimonialFlag = driver.findElement(By.xpath("//img[@class='test_img123']")).isDisplayed();
			WebElement testimonial = driver.findElement(By.xpath("//img[@class='test_img123']"));
			System.out.println(testimonial.isDisplayed());
			System.out.println(testimonial.isEnabled());
			testimonial.click();
			System.out.println(testimonial.getAttribute("alt"));
			System.out.println(testimonial.getAttribute("src"));
			System.out.println(testimonial.getAttribute("class"));
		} catch (Exception e) {
			exceptionMsg = e.getMessage();
			test.log(LogStatus.FAIL, "Testimonial image is not displayed since : " + exceptionMsg);
			e.printStackTrace();
			Assert.assertEquals(testimonialFlag, true, "Testimonial image is not displayed since : " + exceptionMsg);
		}finally {
			if (testimonialFlag) {
				test.log(LogStatus.PASS, "Successfully verified the testimonial image..!");
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
