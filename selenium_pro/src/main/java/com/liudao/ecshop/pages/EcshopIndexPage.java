package com.liudao.ecshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EcshopIndexPage {
	
	private static final Logger logger = LoggerFactory.getLogger(EcshopIndexPage.class);
	
	@FindBy(linkText="请登录")
	private WebElement login_link;
	
	@FindBy(linkText="免费注册")
	private WebElement register_link;
	
	public EcshopIndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginLink() {
		logger.info("点击请登录链接");
		login_link.click();
	}
	
	public void clickRegisterLink() {
		logger.info("点击免费注册链接");
		register_link.click();
	}
}
