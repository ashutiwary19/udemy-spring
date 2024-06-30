package com.ashu.aop.aspects;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggerAspect {
	private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

	@Around("execution(* com.ashu.aop.services.*.*(..))")
	public void log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Instant start = Instant.now();
		logger.info("method execution start");
		proceedingJoinPoint.proceed();
		logger.info("method execution end");
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		logger.info("Time took to execute the method : " + timeElapsed);
	}

	@Around("@annotation(com.ashu.aop.annotations.LogAspect)")
	public void annotationBasedAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("This is annotation based AOp");
		proceedingJoinPoint.proceed();
	}
}
