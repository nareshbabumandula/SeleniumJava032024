package com.selenium.scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TextboxTest {
	
  WebDriver driver;
	
  @Test
  public void textboxMethods() {
	  WebElement username = driver.findElement(By.id("user"));
	  System.out.println(username.isDisplayed());
	  System.out.println(username.isEnabled());
	  username.sendKeys("Saikrishna");
	  String actValue = username.getAttribute("value");
	  Assert.assertEquals(actValue, "Saikrishna", "Expected value is not matched with the actual value");
	  SoftAssert softassert = new SoftAssert();
	  softassert.assertEquals(actValue, "Saikrishna123", "Expected value is not matched with the actual value");
	  System.out.println("Test case completed..!");
	  softassert.assertAll();
  }
     
  @BeforeClass
  public void launchBrowser() {
	  driver = new ChromeDriver();
	  driver.get("https://www.mycontactform.com");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }

    
}
