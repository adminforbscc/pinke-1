package com.liudao.testdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.liudao.utils.DriverServiceUtils;

public class Demo03 {
	private WebDriver driver;
	@BeforeMethod
	public void getDriver() {
		driver = DriverServiceUtils.getDriver("firefox");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	@AfterClass
	public void stopService() {
		DriverServiceUtils.stopService();
	}
	
	@Test
	public void test1() {
		driver.get("https://www.baidu.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		driver.get("http://bbs.51testing.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
