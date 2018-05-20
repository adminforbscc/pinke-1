package com.liudao.utils;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggedRemoteWebDriver extends RemoteWebDriver{
	
	private static final Logger logger = LoggerFactory.getLogger(LoggedRemoteWebDriver.class);
	
	public LoggedRemoteWebDriver() {
		super();
	}
	public LoggedRemoteWebDriver(URL remoteAddress, Capabilities capabilities) {
		super(remoteAddress, capabilities);
	}
	public LoggedRemoteWebDriver(CommandExecutor executor, Capabilities capabilities) {
		super(executor,capabilities);
	}
	
	@Override
	protected WebElement findElement(String by, String using) {
		WebElement element = null;
		try{
			element = super.findElement(by, using);
			logger.info("使用"+by+": "+using+", 找到元素");
		}catch (NoSuchElementException e) {
			logger.error("使用"+by+": "+using+", 未找到元素");
			throw e;
		}
		return element;
	}
	
	@Override
	protected List<WebElement> findElements(String by, String using) {
		List<WebElement> elements = null;
		try{
			elements = super.findElements(by, using);
			logger.info("使用"+by+": "+using+", 找到"+elements.size()+"个元素");
		}catch (NoSuchElementException e) {
			logger.error("使用"+by+": "+using+", 未找到元素");
			throw e;
		}
		return elements;
	}
}
