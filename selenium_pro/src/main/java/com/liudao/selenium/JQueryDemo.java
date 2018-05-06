package com.liudao.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JQueryDemo {
	public static void main(String[] args) {
		WebDriver driver = MyDriverService.getDriver();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		/*driver.get("https://www.csdn.net/");
		
		WebElement element = (WebElement) ((JavascriptExecutor)driver).executeScript("return $(':text')[0];");
		element.sendKeys("httpclient");*/
		driver.get("http://www.w3school.com.cn");
		String script = "var scriptNode = document.createElement(\"script\");" + 
				"scriptNode.setAttribute(\"src\",\"http://code.jquery.com/jquery-latest.js\");" + 
				"scriptNode.setAttribute(\"type\",\"text/javascript\");" + 
				"document.head.appendChild(scriptNode);";
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript(script);
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}*/
		
		//WebDriverWait wait = new WebDriverWait(driver, 5L);
		//ExpectedCondition<Object> eco = ExpectedConditions.jsReturnsValue("return $('div#d1 > h2')[0];");
		WebElement element = (WebElement)new WebDriverWait(driver, 5L).until(
				ExpectedConditions.jsReturnsValue("return $('div#d1 > h2')[0];"));
		
		//WebElement element = (WebElement) executor.executeScript("return $('div#d1 > h2')[0];");
		System.out.println(element.getText());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		MyDriverService.stopService();
	}
}
