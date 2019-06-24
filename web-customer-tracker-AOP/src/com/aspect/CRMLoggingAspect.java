package com.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	Logger myLogger = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	@Pointcut("execution(* com.kvvinay.*.*(..))")
	private void Controller() {}
	
	@Pointcut("execution(* com.kvvinay.dao.*.*(..))")
	private void DAO() {}
	
	@Pointcut("execution(* com.kvvinay.dao.*.*(..))") 
	private void Service() {}
	
	@Pointcut("Controller() || DAO() || Service()")
	private void All() {}
	
	@Before("All()")
	private void before(JoinPoint jp) {
		
		String Method = jp.getSignature().toShortString();
		myLogger.info("===>> in @Before: calling method " + Method);
		
		Object[] args = jp.getArgs();
		
		for (Object temp : args) {
			myLogger.info("====>> Args = "+temp);
		}
		
	}
	
	
	@AfterReturning(pointcut="All()", returning = "result")
	public void afterreturn(JoinPoint jp, Object result ) {
		String Method = jp.getSignature().toShortString();
		myLogger.info("=====>>  @AfterReturning: from method: " + Method);
		
		myLogger.info("====>> Result: " +result);  
	}
	
	
	
	
	
	

}
