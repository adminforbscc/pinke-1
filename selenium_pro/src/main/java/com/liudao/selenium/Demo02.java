package com.liudao.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Demo02 {
	public static void main(String[] args) {
		WebDriver driver = MyDriverService.getDriver();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("https://www.taobao.com");
		WebElement div = driver.findElement(By.cssSelector("div[data-name='goods']"));
		int y = div.getLocation().y;
		((JavascriptExecutor)driver).executeScript(
				"window.scrollTo(0,arguments[0])",y);
		WebElement goodsItem = driver.findElement(By.id("dg-item-tl-0"));
		System.out.println(goodsItem.getText());
		WebElement img = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.images[4]");
		System.out.println(img.getAttribute("src"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		MyDriverService.stopService();
	}
}
