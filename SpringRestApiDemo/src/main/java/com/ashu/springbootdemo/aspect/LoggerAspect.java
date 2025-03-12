package com.ashu.springbootdemo.aspect;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggerAspect {

	@Around("execution(* com.ashu.springbootdemo..*.*(..))")
	public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		log.info(proceedingJoinPoint.getSignature().toString() + " method execution start...");
		Instant start = Instant.now();
		Object returnObj = proceedingJoinPoint.proceed();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		log.info("Time took to execute the method : " + proceedingJoinPoint.getSignature().toString() + "===>"
				+ timeElapsed);
		return returnObj;
	}

	@AfterThrowing(value = "execution(* com.ashu.springbootdemo.*.*(..))", throwing = "ex")
	public void logException(JoinPoint joinpoint, Exception ex) {
		log.error(joinpoint.getSignature().toString() + " is throwing exception err : " + ex.getMessage());

	}
}
