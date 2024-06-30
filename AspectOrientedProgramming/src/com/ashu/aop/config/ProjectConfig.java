package com.ashu.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ashu.aop.MainClass;

@Configuration
@ComponentScan(basePackageClasses = MainClass.class)
@EnableAspectJAutoProxy
public class ProjectConfig {

}
