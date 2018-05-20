package com.liudao.test.listeners;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class WebDriverTestListener extends TestListenerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(WebDriverTestListener.class);
	
	@Override
	public void onTestFailure(ITestResult tr) {
		String className = tr.getTestClass().getName();
		String methodName = tr.getName();
		// 1. 通过反射，从测试类中取出当前运行的浏览器对应的driver对象
		Object currentTestObject = tr.getInstance(); // 获取当前正在运行的测试类的实例
		Class<?> currentTestClass = tr.getTestClass().getRealClass(); // 获取当前的运行的测试类
		try {
			Field webDriverField = currentTestClass.getDeclaredField("driver"); // 获取当前测试类中定义的driver字段
			webDriverField.setAccessible(true); // 设置该字段可被访问，防止被人设置为private属性
			WebDriver driver = (WebDriver) webDriverField.get(currentTestObject); // 获取driver对象
			// 2. 定义截图的目录和文件名
			File path = new File("target/snapshots");
			if(!path.isDirectory()) {
				logger.info(path.getName()+"目录不存在，创建该目录");
				path.mkdir();
			}
			SimpleDateFormat data = new SimpleDateFormat("YYYY-MM-dd_HH_mm_ss");
			String filename = className + "."+methodName+"_"+data.format(new Date())+".png";
			File file = new File(path,filename);
			// 3. 执行截图，并保存
			File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			screen.renameTo(file);
			
		} catch (NoSuchFieldException e) {
			logger.error("未在测试类"+className+"中找到driver字段，自动截图功能失效");
			e.printStackTrace();
		} catch (SecurityException e) {
			logger.error("测试类"+className+"中无法访问driver字段，自动截图功能失效");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			logger.error("测试类"+className+"中driver字段实例化失败，自动截图功能失效");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error("测试类"+className+"中driver字段访问异常，自动截图功能失效");
			e.printStackTrace();
		}
		super.onTestFailure(tr);
	}
}
