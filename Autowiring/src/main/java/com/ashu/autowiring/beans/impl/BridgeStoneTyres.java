package com.ashu.autowiring.beans.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ashu.autowiring.beans.Tyres;

@Component
@Scope("prototype")
public class BridgeStoneTyres implements Tyres {

	public BridgeStoneTyres() {
		System.out.println("BridgeStoneTyres");
	}
	
	public void rotate() {
		System.out.println("ssssssssss.....");
	}

}
