package com.liudao.testdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.liudao.pages.GreatOnceLoginPage;
import com.liudao.selenium.MyDriverService;

public class GreatOnceLoginTest {
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
//				PageFactory.initElements(driver, GreatOnceLoginPage.class);
		loginPage.do_login("bz", "888888");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.get("http://118.178.99.12:30003/login");
		loginPage.do_login("bz", "888888");
	}
	
	@Test
	public void test_nomal() {
		driver.get("http://118.178.99.12:30003/login");
		WebElement user_input = driver.findElement(By.cssSelector("input[placeholder='请输入用户名']"));
		WebElement pwd_input = driver.findElement(By.cssSelector("input[placeholder='请输入2-20位密码']"));
		user_input.sendKeys("bz");
		pwd_input.sendKeys("888888");
		driver.findElement(By.xpath("//button")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.get("http://118.178.99.12:30003/login");
		user_input = driver.findElement(By.cssSelector("input[placeholder='请输入用户名']"));
		pwd_input = driver.findElement(By.cssSelector("input[placeholder='请输入2-20位密码']"));
		user_input.sendKeys("bz");
		pwd_input.sendKeys("888888");
	}
}
