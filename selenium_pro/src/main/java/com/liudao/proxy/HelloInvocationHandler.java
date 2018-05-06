package com.liudao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloInvocationHandler implements InvocationHandler {
	
	private Class<?> clazz;
	
	public HelloInvocationHandler(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object object = clazz.newInstance();
		
		System.out.println("开始执行"+method.getName()+"方法");
		Object ret = method.invoke(object, args);
		System.out.println(method.getName()+"方法执行完毕");
		return ret;
	}

}
