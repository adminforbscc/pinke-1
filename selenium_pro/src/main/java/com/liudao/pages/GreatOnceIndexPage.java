package com.liudao.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreatOnceIndexPage {
	
	private WebDriver driver;
	
	private Map<String, WebElement> menuMap = new HashMap<>();
	
	@FindBy(xpath="//ul[@role='menubar']/li[@role='menuitem']")
	private List<WebElement> menuList;
	
	@FindBy(xpath="//ul[@role='menubar']/li[@role='menuitem']/ul/li")
	private List<WebElement> submenuList;
	
	@FindBy(xpath="//span[text()='新增']")
	private WebElement newOrder_btn;
	
	public GreatOnceIndexPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		menuMap.put("B2C订单", menuList.get(0));
		menuMap.put("B2C售后", menuList.get(1));
		menuMap.put("唯品", menuList.get(2));
		menuMap.put("订单管理", menuList.get(3));
		menuMap.put("营销管理", menuList.get(4));
		menuMap.put("商品管理", menuList.get(5));
		menuMap.put("库存管理", menuList.get(6));
		menuMap.put("采购管理", menuList.get(7));
		menuMap.put("系统设置", menuList.get(8));
		menuMap.put("模板", menuList.get(9));
	}
	
	public void new_order() {
		menuMap.get("B2C订单").click();
		new WebDriverWait(driver, 5L)
			.until(ExpectedConditions.elementToBeClickable(submenuList.get(0)))
			.click();
		new WebDriverWait(driver, 5L)
			.until(ExpectedConditions.elementToBeClickable(newOrder_btn))
			.click();
	}
	
}
