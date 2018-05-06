package com.liudao.driver.beans;

import java.util.Map;

public class ChromeConfig {
	private String driver;
	private int port;
	private Map<String, ?> options;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Map<String, ?> getOptions() {
		return options;
	}
	public void setOptions(Map<String, ?> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "ChromeConfig [driver=" + driver + ", port=" + port + ", options=" + options + "]";
	}
	
}
