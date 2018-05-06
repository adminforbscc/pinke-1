package com.liudao.selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SendKeysDemo {
	public static void main(String[] args) {
		WebDriver driver = MyDriverService.getDriver();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.get("https://www.baidu.com");
		WebElement search_input = driver.findElement(By.id("kw"));
		search_input.sendKeys("Spring"," ","cloud");
		
		Actions actions = new Actions(driver);
		actions.doubleClick(search_input).perform();
		search_input.sendKeys(Keys.CONTROL,"c");
		search_input.sendKeys(Keys.CONTROL,"v");
		search_input.sendKeys(Keys.CONTROL,"v");
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		file.renameTo(new File("c:\\pic\\search.png"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		MyDriverService.stopService();
	}
}
