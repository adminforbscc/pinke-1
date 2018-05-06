package com.liudao.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {
	public static void main(String[] args) {
		WebDriver driver = MyDriverService.getDriver();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		/*driver.get("http://www.qq.com");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("searchSelected")))
			.moveToElement(driver.findElement(By.xpath("//li[text()='µØÍ¼']")))
			.perform();*/
		driver.get("http://localhost/2018selenium01/action.html");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("log")))
			.perform();
		driver.findElement(By.name("username")).sendKeys("123");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		MyDriverService.stopService();
	}
}
