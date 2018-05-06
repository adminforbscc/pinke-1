package com.liudao.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreatOnceOrderPage {
	private WebDriver driver;
	
	@FindBy(xpath="//label[text()='下单时间']/../div/div")
	private WebElement orderDate_input;
	
	@FindBy(xpath="//input[@placeholder='选择日期']")
	private WebElement xzrq_input;
	
	@FindBy(xpath="//input[@placeholder='选择时间']")
	private WebElement xzsj_input;
	
	@FindBy(xpath="//div[@class='el-picker-panel__footer']/button[2]")
	private WebElement confirm_btn;
	
	public GreatOnceOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void setOrderDate(String ymd, String time) {
		orderDate_input.click();
		xzrq_input.clear();
		xzrq_input.sendKeys(ymd);
		xzsj_input.click();
		if(new WebDriverWait(driver, 5L)
			.until(ExpectedConditions.attributeToBeNotEmpty(xzsj_input, "value"))
		) {
			xzsj_input.clear();
		}
		xzsj_input.sendKeys(time);
		confirm_btn.click();
	}
}
