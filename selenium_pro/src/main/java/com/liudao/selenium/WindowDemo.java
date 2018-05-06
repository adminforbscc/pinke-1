package com.liudao.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowDemo {
	public static void main(String[] args) {
		WebDriver driver = MyDriverService.getDriver();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("test");
		driver.findElement(By.id("su")).click();
		
		driver.findElement(By.cssSelector("div[id='1'] > h3 > a")).click();
		
		String firstWindow = driver.getWindowHandle();
		
		Set<String> handles = driver.getWindowHandles();
		
		for(String handle : handles) {
			if(!handle.equals(firstWindow)) {
				driver.switchTo().window(handle);
			}
		}
		
		//System.out.println(driver.getTitle());
		
		driver.findElement(By.id("baidu_translate_input")).sendKeys(" report");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		MyDriverService.stopService();
	}
}
