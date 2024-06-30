package com.ashu.aop.aspects;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class VehicleStartCheckAspect {
	private Logger logger = Logger.getLogger(VehicleStartCheckAspect.class.getName());

	@Before("execution(* com.ashu.aop.services.*.*(..)) && args(vehicleStarted,..)")
	public void checkVehicleStarted(JoinPoint joinPoint, boolean vehicleStarted) {
		if (!vehicleStarted) {
			logger.log(Level.SEVERE, "Vehicle not started to perform the" + " operation");
			throw new RuntimeException("Vehicle not started");
		}
	}
}
