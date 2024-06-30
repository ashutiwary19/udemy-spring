package com.ashu.aop.interfaces.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ashu.aop.interfaces.Tyres;

@Component
@Primary
public class MichelinTyres implements Tyres {

	public String rotate() {
		return "seeeeuuuuuuu...";
	}

	@Override
	public String stop() {
		// TODO Auto-generated method stub
		return "cheeeeeek";
	}

}
