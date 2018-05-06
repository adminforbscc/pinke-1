package com.liudao.proxy;

public class Hello implements IHello{

	@Override
	public void sayHi(String name) {
		System.out.println("Hi, "+name);
	}

}
