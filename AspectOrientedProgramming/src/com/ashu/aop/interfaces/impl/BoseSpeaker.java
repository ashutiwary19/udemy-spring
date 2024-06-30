package com.ashu.aop.interfaces.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ashu.aop.interfaces.Speaker;
import com.ashu.aop.models.Song;

@Component
@Primary
public class BoseSpeaker implements Speaker {

	public String makeSound(Song song) {
		return song + "\n" + "Bum bum bum brraaa bum bum...";
	}

}
