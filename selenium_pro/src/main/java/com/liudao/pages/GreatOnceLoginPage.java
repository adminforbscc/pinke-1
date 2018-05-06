package com.liudao.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GreatOnceLoginPage {
	@FindBy(css="input[placeholder='请输入用户名']")
	private WebElement username_input;
	
	@FindBy(css="input[placeholder='请输入2-20位密码']")
	private WebElement password_input;
	
	@FindBy(xpath="//button")
	private WebElement login_btn;
	
	public GreatOnceLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void do_login(String username, String password) {
		username_input.sendKeys(username);
		password_input.sendKeys(password);
		login_btn.click();
	}
}
