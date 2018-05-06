package com.liudao.testdemo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Demo02 {
	@Test
	public void test21() {
		System.out.println("now running in test21...");
		int x = 1, y = 2;
		int expected = 3;
		int actual = x + y;
		assertEquals(actual,expected);
	}
	@Test
	public void test22() {
		System.out.println("now running in test22...");
		int x = 1, y = 2;
		int expected = 4;
		int actual = x + y;
		assertEquals(actual,expected);
	}
	
}
