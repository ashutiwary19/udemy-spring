package com.ashu.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Duck {
	private String type;

	@PostConstruct
	private void init() {
		this.type = "Persion";
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroy the object");
	}

	public void quack() {
		System.out.println("Quuuuaaack...");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
