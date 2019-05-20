package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean  addSillyMember() {
		System.out.println(getClass() + ": DOING MY DBWORK: ADDING A MEMBERSHIP ACCOUNT");
		return true;
	}
	
	public boolean goToSleep() {
		System.out.println(getClass() + ": goToSleep()");
		return false;
	}
}
