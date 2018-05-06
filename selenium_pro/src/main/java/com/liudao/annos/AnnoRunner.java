package com.liudao.annos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoRunner {
	public static void main(String[] args) {
		AnnoDemo anno = new AnnoDemo();
		//anno.sayNo();
		Method[] methods = AnnoDemo.class.getDeclaredMethods();
		for(Method method : methods) {
			if(method.getAnnotation(RunNum.class) != null) {
				int times = method.getAnnotation(RunNum.class).times();
				for(int i = 0; i < times; i++) {
					try {
						method.invoke(anno);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
			}
		}
	}
}
