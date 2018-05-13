package com.liudao.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.liudao.ecshop.pages.EcshopIndexPage;
import com.liudao.ecshop.pages.EcshopRegisterPage;
import com.liudao.utils.DriverServiceUtils;

public class DemoPage {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = DriverServiceUtils.getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://localhost/ecshop");
		EcshopIndexPage index = new EcshopIndexPage(driver);
		index.clickRegisterLink();
		EcshopRegisterPage register = new EcshopRegisterPage(driver);
		String ret = register.inputUsername("liudao001").getText();
		System.out.println(ret);
		register.inputEmail("liudao001@163.com");
		ret = register.inputPassword("123456").getText();
		System.out.println(ret);
		System.out.println(register.getPasswordStrength());
		register.inputConfirmPassword("123456");
		register.inputMobileNumber("1351351236");
		register.clickRegBtn();
		System.out.println(driver.getPageSource());
		
		Thread.sleep(3000);
		
		driver.close();
		DriverServiceUtils.stopService();
	}
}
