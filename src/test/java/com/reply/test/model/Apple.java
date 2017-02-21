package com.reply.test.model;

public class Apple {

	private int juice;
	
	public Apple() {
		this.juice = 100;
	}
	
	public void drain(int amount) {
		this.juice -= amount;
	}
	
	public String getName() {
		return "Apple";
	}
	
	public int getJuice() {
		return juice;
	}
}
