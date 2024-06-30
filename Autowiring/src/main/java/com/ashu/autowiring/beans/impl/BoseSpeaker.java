package com.ashu.autowiring.beans.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ashu.autowiring.beans.Speaker;

@Component
public class BoseSpeaker implements Speaker {

	public void makeSound() {
		System.out.println("Bum bum bum brraaa bum bum...");
	}

}
