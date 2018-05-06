package com.liudao.api;

public class Fibonacci {
	public static int fibo(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}else if(n > 2) {
			return fibo(n-1)+fibo(n-2);
		}else {
			throw new ArithmeticException("传入参数错误");
		}
	}
}
