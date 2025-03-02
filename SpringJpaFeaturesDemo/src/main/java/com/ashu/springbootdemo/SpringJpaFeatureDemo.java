package com.ashu.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ashu.springbootdemo.model")
@EnableJpaRepositories("com.ashu.springbootdemo.repository")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class SpringJpaFeatureDemo {
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaFeatureDemo.class, args);
	}
}
