package com.liudao.testdemo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Demo01 {
	@Test
	public void test11() {
		System.out.println("now running in test11...");
		int x = 1, y = 2;
		int expected = 3;
		int actual = x + y;
		assertEquals(actual,expected);
	}
	@Parameters({"url","jdbc_user"})
	@Test
	public void test12(String url, String user) {
		System.out.println("now running in test12...");
		System.out.println(url);
		System.out.println(user);
		int x = 1, y = 2;
		int expected = 4;
		int actual = x + y;
		assertEquals(actual,expected);
	}
	
	@BeforeMethod
	public void beforeTestMethod() {
		System.out.println("now running in beforeTestMethod...");
	}
	
	@AfterMethod
	public void afterTestMethod() {
		System.out.println("now running in afterTestMethod...");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("now running in beforeClass...");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("now running in afterClass...");
	}
}
