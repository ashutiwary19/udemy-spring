package com.ashu.autowiring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ashu.autowiring.Demo;

@Configuration
@ComponentScan(basePackageClasses = Demo.class)
public class AutowiringConfig {

}
