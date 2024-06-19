package com.ashu.beans;

public class Coffee {
	private String type;

	public void brew() {
		System.out.println("brewing");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
