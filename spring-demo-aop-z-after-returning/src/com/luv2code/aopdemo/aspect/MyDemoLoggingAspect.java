package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningfindAccountsAdvice(JoinPoint theJoinPoint, 
			List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n====> Executing @AfterReturning on method: " + method);
		
		System.out.println("\n====> result is: " + result);

		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n====> result is: " + result);
		
		
	}
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvise(JoinPoint theJoinPoint) {
		System.out.println("\n====>>> Executing @Before advise on method");
	
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display the method arguments
		
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		// loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for (Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
		}
	}
	
}
