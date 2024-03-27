package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class XPathAxesTest {
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	@Test
	public void xpathaxesExamples() throws InterruptedException {
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
						
		try {
			driver.findElement(By.linkText("Sample Forms")).click();	
			//Ancestor Axes
			driver.findElement(By.xpath("//input[@id='pass']/ancestor::fieldset/div/input")).sendKeys("keerthana@gmail.com");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='pass']/ancestor::fieldset/div/input[@id='user']")).clear();
			//Ancestor-or-self Axes
			driver.findElement(By.xpath("//input[@name='q11_last']/ancestor-or-self::input")).sendKeys("Sai");
			Thread.sleep(1000);
			//Self Axes
			driver.findElement(By.xpath("//input[@id='user' and @class='txt_log']/self::input")).sendKeys("divya@gmail.com");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='pass']/ancestor::fieldset/div/input[@id='user']")).clear();
			//Descendant Axes
			driver.findElement(By.xpath("//form[@id='contactForm']/descendant::input[@id='subject']")).sendKeys("Sampleform");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//form[@id='contactForm']/descendant::input[@id='subject']")).clear();
			//Descendant-or self Axes
			driver.findElement(By.xpath("//textarea[@id='q2']/descendant-or-self::textarea")).sendKeys("Fill the sampleform");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//textarea[@id='q2']/descendant-or-self::textarea")).clear();
			//child Axes
			driver.findElement(By.xpath("//div[@id='right_col_wrapper']/child::div/form/fieldset/div[1]/input")).sendKeys("keerthana");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='right_col_wrapper']/child::div/form/fieldset/div[1]/input")).clear();
			//Following Axes
			driver.findElement(By.xpath("//input[@id='subject']/following::input")).sendKeys("Arha@gmail.com");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='subject']/following::input")).clear();
			//Following-sibling  Axes
			driver.findElement(By.xpath("//input[@id='q6']/following-sibling::input")).click();
			Thread.sleep(1000);
			//preceding Axes
			driver.findElement(By.xpath("//input[@name='q7']/preceding::select")).sendKeys("Fourth Option");
			Thread.sleep(1000);
			//preceding-sibling Axes
			driver.findElement(By.xpath("//input[@name='q11_last']/preceding-sibling::select")).sendKeys("Miss");
			Thread.sleep(1000);
			//Parent Axes
			driver.findElement(By.xpath("//input[@id='pass']/parent::div/input")).sendKeys("aadhya");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='pass']/parent::div/input")).clear();
			//Attribute Axes
			driver.findElement(By.xpath("//input[@id='q1']")).sendKeys("Hai..!");
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "Test Passed");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Test Failed" + e.getMessage());
		}
	}
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("TC001");
	}
	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}

