package com.liudao.annos;

public class AnnoDemo {
	@RunNum(times=3)
	public void sayHi() {
		System.out.println("hi!");
	}
	
	public void sayNo() {
		System.out.println("no");
	}
}
