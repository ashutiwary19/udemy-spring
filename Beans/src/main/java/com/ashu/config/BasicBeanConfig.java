package com.ashu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ashu.Demo;
import com.ashu.beans.Vehicle;

// rather than doing all these we can simply use @Component
@Configuration
@ComponentScan(basePackageClasses = Demo.class)
public class BasicBeanConfig {

	@Bean("maruti")
	public Vehicle maruti() {
		Vehicle maruti = new Vehicle();
		maruti.setName("Maruti");
		maruti.setEngineStartSound("Brrrrrr....");
		return maruti;
	}

	@Primary
	@Bean("ferrari")
	public Vehicle Ferrari() {
		Vehicle maruti = new Vehicle();
		maruti.setName("Ferrari");
		maruti.setEngineStartSound("hhhhhhh....");
		return maruti;
	}

}
