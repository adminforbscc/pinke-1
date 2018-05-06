package com.liudao.testdemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.liudao.api.Fibonacci;

public class FibonacciTest {
	
	@DataProvider(name="fibo_test_data")
	public Object[][] getFiboTestData(){
		return new Object[][] {
			{1,1},
			{2,1},
			{6,8}
		};
	}
	
	@Test(dataProvider="fibo_test_data")
	public void testFibo01(int n, int expected) {
		int actual = Fibonacci.fibo(n);
		assertEquals(actual, expected);
	}
	
	@Test
	public void testFibo_negative() {
		int n = 0;
		try {
			Fibonacci.fibo(n);
		}catch(Exception e) {
			assertTrue(e instanceof ArithmeticException);
			assertEquals(e.getMessage(), "传入参数错误");
		}
	}
}
