package com.liudao.selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyDriverService {
	private static ChromeDriverService service;
	private static ChromeOptions options;
	static {
		service = new ChromeDriverService.Builder()
				.usingAnyFreePort()
				.usingDriverExecutable(new File("C:/Course/Selenium/工具/drivers/chrome/2.36/chromedriver.exe"))
				.build();
		options = new ChromeOptions();
		options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		options.setAcceptInsecureCerts(true);
	}
	public static WebDriver getDriver() {
		return new ChromeDriver(service, options);
	}
	public static void stopService() {
		service.stop();
	}
}
