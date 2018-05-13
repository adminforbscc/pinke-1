package com.liudao.ecshop.testdatas;

import org.testng.annotations.DataProvider;

public class DataProviderFactory {
	@DataProvider(name="registerTestData")
	public static Object[][] getRegisterTestData(){
		return new Object[][] {
			{"liudao001","liudao001@163.com","123456","123456","123","用户名 liudao001 注册成功"},
			{"liudao002","liudao002@163.com","123456","1234567","123","- 两次输入密码不一致\n"}
		};
	}
	
}
