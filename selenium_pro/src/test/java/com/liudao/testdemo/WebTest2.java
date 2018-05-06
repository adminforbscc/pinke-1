package com.liudao.testdemo;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.liudao.selenium.MyDriverService;

public class WebTest2 {
	
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
		driver.get("http://bbs.51testing.com/forum.php");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor)driver).executeScript(
				"window.scrollTo(0,arguments[0])",500);
		driver.findElement(By.linkText("[软件测试新手上路]")).click();;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement element = driver.findElement(By.xpath("//tbody[starts-with(@id,'normalthread')]/tr/th/a[3]"));
		((JavascriptExecutor)driver).executeScript(
				"window.scrollTo(0,arguments[0])",2500);
		driver.findElement(By.linkText("2")).click();
		System.out.println(element.getText());
		element.click();
	}
	
}
