package com.liudao.proxy;

import java.lang.reflect.Proxy;

public class Demo {
	public static void main(String[] args) {
		/*IHello hello = new Hello();
		hello.sayHi("liudao");*/
		ClassLoader loader = Hello.class.getClassLoader();
		Class<?>[] interfaces = new Class<?>[] {IHello.class};
		HelloInvocationHandler h = new HelloInvocationHandler(Hello.class);
		IHello hello = (IHello)Proxy.newProxyInstance(loader, interfaces, h);
		hello.sayHi("liudao");
	}
}
