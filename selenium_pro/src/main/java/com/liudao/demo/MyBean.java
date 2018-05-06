package com.liudao.demo;

public class MyBean {
	private Friend friend;

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	@Override
	public String toString() {
		return "MyBean [friend=" + friend + "]";
	}
}
