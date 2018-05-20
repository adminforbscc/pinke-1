package com.liudao.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertDemo {
	public static void main(String[] args) {
		/*WebDriver driver = MyDriverService.getDriver();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("http://localhost/2018selenium01/alert.html");
		
		driver.findElement(By.id("alert_btn")).click();
		Alert alert1 = new WebDriverWait(driver, 5L).until(ExpectedConditions.alertIsPresent());
		//Alert alert1 = driver.switchTo().alert();
		System.out.println("��һ��������ϵ������ǣ�"+alert1.getText());
		alert1.accept();
		
		driver.findElement(By.id("confirm_btn")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println("�ڶ���ȷ�Ͽ��ϵ������ǣ�"+alert2.getText());
		alert2.dismiss();
		
		driver.findElement(By.id("prompt_btn")).click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println("��������ʾ���ϵ������ǣ�"+alert3.getText());
		alert3.sendKeys("��������");
		alert3.accept();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		MyDriverService.stopService();*/
	}
}
