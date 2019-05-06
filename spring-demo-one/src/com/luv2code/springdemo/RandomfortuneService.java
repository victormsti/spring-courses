package com.luv2code.springdemo;

import java.util.Random;

public class RandomfortuneService implements FortuneService {

	
	private String[] data = {
			"Fortune 1",
			"Fortune 2",
			"Fortune 3"
	};
	
	// create a random number generator
	Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
