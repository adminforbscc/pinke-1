package com.liudao.testdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.liudao.pages.GreatOnceIndexPage;
import com.liudao.pages.GreatOnceLoginPage;
import com.liudao.pages.GreatOnceOrderPage;
import com.liudao.selenium.MyDriverService;

public class GreatOnceLoginTest2 {
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
	public void test_login() {
		driver.get("http://118.178.99.12:30003/login");
		GreatOnceLoginPage loginPage = new GreatOnceLoginPage(driver);
		loginPage.do_login("bz", "888888");
		GreatOnceIndexPage indexPage = new GreatOnceIndexPage(driver);
		indexPage.new_order();
		GreatOnceOrderPage orderPage = new GreatOnceOrderPage(driver);
		orderPage.setOrderDate("2008-10-22", "17:30:30");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
