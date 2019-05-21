package com.luv2code.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("Main Program: AroundDemoApp");
		System.out.println("Calling getFortune");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("\nMy fortune is :" + data);
		
		System.out.println("\nFinished!");
		
		context.close();
	}
	
	

}
