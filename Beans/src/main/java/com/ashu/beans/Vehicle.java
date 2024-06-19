package com.ashu.beans;

public class Vehicle {

	private String name;
	private String engineStartSound;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngineStartSound() {
		return engineStartSound;
	}

	public void setEngineStartSound(String engineStartSound) {
		this.engineStartSound = engineStartSound;
	}

	public void startEngine() {
		System.out.println(this.getName() + " goes " + this.getEngineStartSound());
	}

}
