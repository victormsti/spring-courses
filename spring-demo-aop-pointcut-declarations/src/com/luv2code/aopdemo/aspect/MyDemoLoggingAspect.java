package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvise() {
		System.out.println("\n====>>> Executing @Before advise on method");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytcs() {
		System.out.println("\n====> Perming API analytcs");
	}
}
