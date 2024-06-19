package com.ashu.autowiring.beans.impl;

import org.springframework.stereotype.Component;

import com.ashu.autowiring.beans.Speaker;

@Component
public class SonySpeaker implements Speaker {

	public void makeSound() {
		System.out.println("Boom chika chika...");
	}

}
