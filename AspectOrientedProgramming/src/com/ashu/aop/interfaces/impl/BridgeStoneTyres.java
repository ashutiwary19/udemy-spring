package com.ashu.aop.interfaces.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ashu.aop.interfaces.Tyres;

@Component
@Scope("prototype")
public class BridgeStoneTyres implements Tyres {

	public BridgeStoneTyres() {
		System.out.println("BridgeStoneTyres");
	}

	public String rotate() {
		return "ssssssssss.....";
	}

	@Override
	public String stop() {
		return "Chennnnnnnnnnnnnuuuu";
	}

}
