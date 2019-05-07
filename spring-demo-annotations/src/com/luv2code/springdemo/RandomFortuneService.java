package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	public String[] data = {
	"random1",
	"random2",
	"random3"
	};
	
	private Random randomFortune = new Random();
	
	
	@Override
	public String getFortune() {
		
		int index = randomFortune.nextInt(data.length);
		return data[index];
	}

}
