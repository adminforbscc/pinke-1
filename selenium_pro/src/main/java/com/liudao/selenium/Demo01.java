package com.liudao.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo01 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Course\\Selenium\\¹¤¾ß\\drivers\\chrome\\2.36\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.baidu.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
}
