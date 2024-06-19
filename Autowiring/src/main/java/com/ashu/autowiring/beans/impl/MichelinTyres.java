package com.ashu.autowiring.beans.impl;

import org.springframework.stereotype.Component;

import com.ashu.autowiring.beans.Tyres;

@Component
public class MichelinTyres implements Tyres {

	public void rotate() {
		System.out.println("seeeeuuuuuuu...");
	}

}
