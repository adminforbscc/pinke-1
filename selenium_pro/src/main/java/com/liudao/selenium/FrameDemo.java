package com.liudao.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameDemo {
	public static void main(String[] args) {
		WebDriver driver = MyDriverService.getDriver();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		//System.out.println(driver.getPageSource());
		//driver.switchTo().frame("classFrame");
		//driver.switchTo().frame(2);
		driver.switchTo().frame(driver.findElement(By.name("classFrame")));
		System.out.println(driver.findElement(By.className("navBarCell1Rev")).getText());
		driver.switchTo().parentFrame();
		driver.switchTo().frame("packageListFrame");
		System.out.println(driver.findElement(By.className("indexHeader")).getText());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		MyDriverService.stopService();
	}
}
