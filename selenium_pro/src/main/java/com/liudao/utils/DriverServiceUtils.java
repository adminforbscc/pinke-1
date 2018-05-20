package com.liudao.utils;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.service.DriverService;

import com.liudao.driver.beans.ChromeConfig;
import com.liudao.driver.beans.GeckoConfig;
/**
 * DriverService单例启动类
 * @author liudao
 *
 */
public class DriverServiceUtils {
	/**
	 * serviceMap用于存放浏览器名和service、options数组的键值对，map的key是浏览器名，value是object类型的
	 * 数组，object数组只保存两个值，分别是DriverService和Options
	 */
	private static Map<String, Object[]> serviceMap;
	
	static {
		serviceMap = new LinkedHashMap<>();
	}
	
	/**
	 * 获取指定浏览器名称的对应的driver对象。
	 * 如果该浏览器对应的driver所需要连接的service未启动，则读取配置文件driver_configure.yml创建service实例，
	 * 并根据options选项创建Options对象，用service和options实例化driver。
	 * 如果该浏览器对应的driver所需要连接的service已存在，则直接使用。确保service不会被反复启动
	 * @param browserName 浏览器名称，如firefox，chrome，名称忽略大小写
	 * @return 浏览器名称所对应的driver对象
	 */
	public static WebDriver getDriver(String browserName) {
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase(BrowserType.CHROME)) { // 如果浏览器是谷歌浏览器
			if(!serviceMap.containsKey(BrowserType.CHROME)) { // 判断静态map中是否存在chrome字段，如果不存在，则表示该service未创建过
				ChromeConfig config = Configure.getConfig().getChrome(); // 从配置文件中获取关于chrome的配置信息
				ChromeDriverService service = new ChromeDriverService.Builder()
						.usingPort(config.getPort())
						.usingDriverExecutable(new File(config.getDriver()))
						.build();
				ChromeOptions options = new ChromeOptions(); // 创建options对象
				Map<String,?> optionsMap = config.getOptions(); // 从配置文件中获取options的值
				serviceMap.put(BrowserType.CHROME, setOptions(service,options,optionsMap)); // 组合键值对存入静态map中
			}
			Object[] args = serviceMap.get(BrowserType.CHROME); // 从静态map中获取value部分，分别是service和options
			driver = new LoggedChromeDriver((ChromeDriverService)args[0],(ChromeOptions)args[1]); // 调用chromedriver的构造器，传入service参数和options参数，构造driver对象
		}else if(browserName.equalsIgnoreCase(BrowserType.FIREFOX)) { // 判断是否是火狐浏览器
			if(!serviceMap.containsKey(BrowserType.FIREFOX)) {
				GeckoConfig config = Configure.getConfig().getFirefox();
				GeckoDriverService service = new GeckoDriverService.Builder()
						.usingPort(config.getPort())
						.usingDriverExecutable(new File(config.getDriver()))
						.build();
				
				FirefoxOptions options = new FirefoxOptions();
				Map<String,?> optionsMap = config.getOptions();
				serviceMap.put(BrowserType.FIREFOX, setOptions(service,options,optionsMap));
			}
			Object[] args = serviceMap.get(BrowserType.FIREFOX);
			driver = new LoggedFirefoxDriver((GeckoDriverService)args[0],(FirefoxOptions)args[1]);
		}else {
			System.err.println("不支持该浏览器！");
		}
		return driver;
	}
	/**
	 * 根据传入的浏览器名称关闭对应的service
	 * @param browserName 浏览器名称，如firefox，chrome，名称忽略大小写
	 */
	public static void stopService(String browserName) {
		if(browserName.equalsIgnoreCase(BrowserType.CHROME)) {
			if(serviceMap.containsKey(BrowserType.CHROME) ) {
				DriverService service = (DriverService) serviceMap.get(BrowserType.CHROME)[0];
				if(service.isRunning()) {
					service.stop();
				}
			}
		}else if(browserName.equalsIgnoreCase(BrowserType.FIREFOX)) {
			if(serviceMap.containsKey(BrowserType.FIREFOX) ) {
				DriverService service = (DriverService) serviceMap.get(BrowserType.FIREFOX)[0];
				if(service.isRunning()) {
					service.stop();
				}
			}
		}else {
			System.err.println("不支持该浏览器！");
		}
	}
	/**
	 * 关闭所有浏览器对应的service
	 */
	public static void stopService() {
		for(Map.Entry<String, Object[]> entry : serviceMap.entrySet()) {
			stopService(entry.getKey());
		}
	}
	/**
	 * 根据传入的options对象和options的参数，构造options实例，并封装成object数组
	 * @param service object数组的第一个值
	 * @param options object数组的第二个值
	 * @param optionsMap 需要设置在options对象中的参数
	 * @return object数组
	 */
	private static Object[] setOptions(DriverService service, MutableCapabilities options, Map<String, ?> optionsMap){
		String acceptInsecureCerts = (String)optionsMap.get("acceptInsecureCerts");
		if(options instanceof ChromeOptions) {
			if(acceptInsecureCerts != null) {
				((ChromeOptions)options).setAcceptInsecureCerts(Boolean.parseBoolean(acceptInsecureCerts));
			}
			String binary = (String)optionsMap.get("binary");
			if(binary != null) {
				((ChromeOptions)options).setBinary(binary);
			}
		}else if(options instanceof FirefoxOptions){
			if(acceptInsecureCerts != null) {
				((FirefoxOptions)options).setAcceptInsecureCerts(Boolean.parseBoolean(acceptInsecureCerts));
			}
			String binary = (String)optionsMap.get("binary");
			if(binary != null) {
				((FirefoxOptions)options).setBinary(binary);
			}
		}
		Object[] obj  = new Object[] {
				service,
				options
		};
		return obj;
	}
}
