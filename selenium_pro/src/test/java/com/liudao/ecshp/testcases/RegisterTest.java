package com.liudao.ecshp.testcases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.liudao.ecshop.pages.EcshopIndexPage;
import com.liudao.ecshop.pages.EcshopRegisterPage;
import com.liudao.ecshop.testdatas.DataProviderFactory;
import com.liudao.utils.DriverServiceUtils;

public class RegisterTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initDriver() {
		driver = DriverServiceUtils.getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	@AfterClass
	public void stopService() {
		DriverServiceUtils.stopService();
	}
	
	@Test(dataProviderClass=DataProviderFactory.class, dataProvider="registerTestData")
	public void testRegister(
			String username, 
			String email, 
			String password, 
			String confirmPassword, 
			String mobileNumber, 
			String ecpectedMsg) {
		driver.get("http://localhost/ecshop");
		EcshopIndexPage index = new EcshopIndexPage(driver);
		index.clickRegisterLink();
		EcshopRegisterPage register = new EcshopRegisterPage(driver);
		register.inputUsername(username);
		register.inputEmail(email);
		register.inputPassword(password);
		register.inputConfirmPassword(confirmPassword);
		register.inputMobileNumber(mobileNumber);
		register.clickRegBtn();
		if(ecpectedMsg.startsWith("-")) {
			register.assertAlertText(ecpectedMsg);
		}else {
			register.assertRegisterResult(ecpectedMsg);
		}
	}
	
	/*@Test
	public void testRegisterPasswordInconformity() {
		driver.get("http://localhost/ecshop");
		EcshopIndexPage index = new EcshopIndexPage(driver);
		index.clickRegisterLink();
		EcshopRegisterPage register = new EcshopRegisterPage(driver);
		register.inputUsername("liudao001");
		register.inputEmail("liudao001@163.com");
		register.inputPassword("123456");
		register.inputConfirmPassword("1234567");
		register.inputMobileNumber("111");
		register.clickRegBtn();
		register.assertAlertText("- 两次输入密码不一致\n");
	}*/
	
	@Test
	public void testRegisterNameExist() {
		driver.get("http://localhost/ecshop");
		EcshopIndexPage index = new EcshopIndexPage(driver);
		index.clickRegisterLink();
		EcshopRegisterPage register = new EcshopRegisterPage(driver);
		WebElement text_element = register.inputUsername("liudao001");
		assertTrue(new WebDriverWait(driver, 5L)
				.until(ExpectedConditions.textToBePresentInElement(text_element, "* 用户名已经存在,请重新输入")));
	}
}
