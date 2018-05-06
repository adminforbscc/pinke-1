package com.liudao.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.liudao.demo.DemoYaml;
import com.liudao.driver.beans.ConfigEntity;
/**
 * 读取yaml配置文件类
 * @author liudao
 *
 */
public class Configure {
	private static ConfigEntity config;
	static {
		InputStream is = DemoYaml.class.getClassLoader().getResourceAsStream("driver_configure.yml");
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(is,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		YamlReader yr = new YamlReader(isr);
		try {
			config = yr.read(ConfigEntity.class);
		} catch (YamlException e) {
			e.printStackTrace();
		}
	}
	
	public static ConfigEntity getConfig(){
		return config;
	}
}
