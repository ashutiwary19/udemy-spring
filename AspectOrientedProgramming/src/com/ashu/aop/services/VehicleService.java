package com.ashu.aop.services;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashu.aop.annotations.LogAspect;
import com.ashu.aop.interfaces.Speaker;
import com.ashu.aop.interfaces.Tyres;
import com.ashu.aop.models.Song;

@Component
public class VehicleService {

	private Logger logger = Logger.getLogger(VehicleService.class.getName());

	@Autowired
	private Speaker speakers;

	@Autowired
	private Tyres tyres;

	public String playMusic(boolean vehicleStarted, Song song) {

		/*
		 * Instant start = Instant.now(); logger.info("method execution start");
		 */

		String music = speakers.makeSound(song);
		/*
		 * if (vehicleStarted) { music = speakers.makeSound(song); } else {
		 * logger.log(Level.SEVERE, "Vehicle not started to perform the" +
		 * " operation"); }
		 */
		System.out.println(music);
		/*
		 * logger.info("method execution end"); Instant finish = Instant.now(); long
		 * timeElapsed = Duration.between(start, finish).toMillis();
		 * logger.info("Time took to execute the method : " + timeElapsed);
		 */

		return speakers.makeSound(song);
	}

	public String moveVehicle(boolean vehicleStarted) {
		/*
		 * Instant start = Instant.now(); logger.info("method execution start");
		 */

		String status = tyres.rotate();
		;
		/*
		 * if (vehicleStarted) { status = tyres.rotate(); } else {
		 * logger.log(Level.SEVERE, "Vehicle not started to perform the" +
		 * " operation"); }
		 */

		/*
		 * System.out.println(status);
		 * 
		 * logger.info("method execution end"); Instant finish = Instant.now(); long
		 * timeElapsed = Duration.between(start, finish).toMillis();
		 * logger.info("Time took to execute the method : " + timeElapsed);
		 */
		return tyres.rotate();
	}

	@LogAspect
	public String applyBrake(boolean vehicleStarted) {

		/*
		 * Instant start = Instant.now(); logger.info("method execution start");
		 */

		String status = null;
		if (vehicleStarted) {
			status = tyres.stop();
		} else {
			logger.log(Level.SEVERE, "Vehicle not started to perform the" + " operation");
		}

		System.out.println(status);

		/*
		 * logger.info("method execution end"); Instant finish = Instant.now(); long
		 * timeElapsed = Duration.between(start, finish).toMillis();
		 * logger.info("Time took to execute the method : " + timeElapsed);
		 */
		return tyres.stop();
	}

	public Speaker getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Speaker speakers) {
		this.speakers = speakers;
	}

	public Tyres getTyres() {
		return tyres;
	}

	@Autowired
	public void setTyres(Tyres tyres) {
		this.tyres = tyres;
	}
}