package com.ashu.autowiring.beans.impl;

import org.springframework.stereotype.Component;

import com.ashu.autowiring.beans.Tyres;

@Component
public class BridgeStoneTyres implements Tyres {

	public void rotate() {
		System.out.println("ssssssssss.....");
	}

}
