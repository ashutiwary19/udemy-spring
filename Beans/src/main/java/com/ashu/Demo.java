package com.ashu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashu.beans.Coffee;
import com.ashu.beans.Duck;
import com.ashu.beans.Vehicle;
import com.ashu.config.BasicBeanConfig;

public class Demo {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BasicBeanConfig.class);
		context.register(Coffee.class);

//		Vehicle vehicle = context.getBean("ferrari", Vehicle.class);
		Vehicle vehicle = context.getBean(Vehicle.class);
		vehicle.startEngine();

		Duck duck = context.getBean(Duck.class);
		duck.quack();
		System.out.println("Duck type : " + duck.getType());

		Coffee coffee = context.getBean(Coffee.class);
		coffee.brew();

		context.close();
	}
}
