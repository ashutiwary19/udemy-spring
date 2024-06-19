package com.ashu.autowiring.beans.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ashu.autowiring.beans.Speaker;
import com.ashu.autowiring.beans.Tyres;

@Component
public class Vehicle {
	private final Speaker speaker;
	private final Tyres tyres;

	@Autowired
	public Vehicle(@Qualifier("boseSpeaker") Speaker speaker, @Qualifier("michelinTyres") Tyres tyres) {
		super();
		this.speaker = speaker;
		this.tyres = tyres;
	}

	public void move() {
		tyres.rotate();
	}

	public void playMusic() {
		speaker.makeSound();
	}

}
