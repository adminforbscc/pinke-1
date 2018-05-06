package com.liudao.listeners;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter {
	@Override
	public void onStart(ITestContext testContext) {
		ITestNGMethod[] methods = testContext.getAllTestMethods();
		System.out.println("---> 以下所有方法将会被运行");
		for(int i = 0; i < methods.length; i++) {
			
			methods[i].setRetryAnalyzer(new MyRetryAnalyzer(2));
			
			String name = methods[i].getMethodName();
			System.out.println(name);
		}
		
		super.onStart(testContext);
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		String className = tr.getTestClass().getName();
		String methodName = tr.getName();
		System.out.println("---->"+className+"."+methodName+"执行失败");
		super.onTestFailure(tr);
	}
}
