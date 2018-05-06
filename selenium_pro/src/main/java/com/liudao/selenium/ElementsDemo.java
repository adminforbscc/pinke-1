package com.liudao.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsDemo {
	public static void main(String[] args) {
		WebDriver driver = MyDriverService.getDriver();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("http://localhost/2018selenium01/list.html");
		
		List<WebElement> elements = driver.findElements(By.className("item"));
		elements.get(2).click();
		elements.get(3).click();
		elements.get(2).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		MyDriverService.stopService();
	}
}
