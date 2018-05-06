package com.liudao.testdemo;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.liudao.selenium.MyDriverService;

public class WebTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void initDriver() {
		driver = MyDriverService.getDriver();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	@AfterSuite
	public void stopService() {
		MyDriverService.stopService();
	}
	
	@Test
	public void testBaidu() {
		driver.get("https://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("test");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBaidu2() {
		driver.get("https://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("test");
		assertTrue(new WebDriverWait(driver, 5L).until(
				ExpectedConditions.titleContains("test")));
	}
}
