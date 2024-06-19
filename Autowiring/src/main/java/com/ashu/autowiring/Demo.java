package com.ashu.autowiring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashu.autowiring.beans.impl.Vehicle;
import com.ashu.autowiring.config.AutowiringConfig;

public class Demo {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiringConfig.class);
		Vehicle vehicle = context.getBean(Vehicle.class);
		vehicle.move();
		vehicle.playMusic();
	}
}
