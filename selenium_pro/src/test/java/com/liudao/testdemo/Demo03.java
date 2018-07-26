package com.liudao.testdemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.liudao.utils.DriverServiceUtils;

public class Demo03 {
	private WebDriver driver;
	@BeforeMethod
	public void getDriver() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.BROWSER_NAME,BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://192.168.43.1:4444/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
/*	@AfterClass
	public void stopService() {
		DriverServiceUtils.stopService();
	}*/
	
	@Test
	public void test1() {
		driver.get("https://www.baidu.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
