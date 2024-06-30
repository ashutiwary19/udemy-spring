package com.ashu.aop.interfaces.impl;

import org.springframework.stereotype.Component;

import com.ashu.aop.interfaces.Speaker;
import com.ashu.aop.models.Song;

@Component
public class SonySpeaker implements Speaker {

	public String makeSound(Song song) {
		return song + "\n" + "Boom chika chika...";
	}

}
