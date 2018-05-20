package com.liudao.ecshop.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.liudao.ecshop.pages.EcshopIndexPage;
import com.liudao.ecshop.pages.EcshopRegisterPage;
import com.liudao.utils.DriverServiceUtils;

import cucumber.api.java.en.And;

public class RegisterTestSteps {
	
	private WebDriver driver;
	private EcshopIndexPage index;
	EcshopRegisterPage register;
	
	@And("^打开首页\"([^\"]*)\"$")
	public void open_index_page(String url) {
		driver = DriverServiceUtils.getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://localhost/ecshop");
		index = new EcshopIndexPage(driver);
	}
	
	@And("^点击免费注册按钮$")
	public void click_reg_link() {
		index.clickRegisterLink();
		register = new EcshopRegisterPage(driver);
	}
	
	@And("^填写用户名\"([^\"]*)\"$")
	public void input_username(String username) {
		register.inputUsername(username);
	}
	
	@And("^填写邮箱\"([^\"]*)\"$")
	public void input_email(String email) {
		register.inputEmail(email);
	}
	
	@And("^填写密码\"([^\"]*)\"$")
	public void input_password(String password) {
		register.inputPassword(password);
	}
	
	@And("^填写确认密码\"([^\"]*)\"$")
	public void input_password2(String password) {
		register.inputConfirmPassword(password);
	}
	
	@And("^填写手机号\"([^\"]*)\"$")
	public void input_phone(String mobileNumber) {
		register.inputMobileNumber(mobileNumber);
	}
	
	@And("^点击注册按钮$")
	public void click_reg_btn() {
		register.clickRegBtn();
	}
	
	@And("^页面跳转显示\"([^\"]*)\"$")
	public void assert_success(String ecpectedMsg) {
		register.assertRegisterResult(ecpectedMsg);
	}
	
	@And("^关闭浏览器$")
	public void close() {
		driver.close();
		DriverServiceUtils.stopService();
	}
}
