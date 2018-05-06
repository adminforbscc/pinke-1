package com.liudao.listeners;

import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;

public class MyRetryAnalyzer extends RetryAnalyzerCount {
	
	public MyRetryAnalyzer(int retryTimes) {
		setCount(retryTimes);
	}

	@Override
	public boolean retryMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("--->方法："+result.getName()+"需要重跑");
			return true;
		}else {
			return false;
		}
	}

}
