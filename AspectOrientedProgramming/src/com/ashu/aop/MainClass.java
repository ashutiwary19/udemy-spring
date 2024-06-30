package com.ashu.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashu.aop.config.ProjectConfig;
import com.ashu.aop.models.Song;
import com.ashu.aop.services.VehicleService;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		VehicleService vehicleService = context.getBean(VehicleService.class);
		vehicleService.moveVehicle(true);
		Song song = new Song();
		song.setSingerName("Jon Bon Jovi");
		song.setTitle("Its mahh life");
		vehicleService.playMusic(true, song);
		vehicleService.applyBrake(true);
		context.close();
	}

}
