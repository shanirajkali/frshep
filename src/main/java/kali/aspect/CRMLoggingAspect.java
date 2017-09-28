package kali.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup point cut declarations
	@Pointcut("execution(* kali.web.controller.*.*(..))")
	private void forControllerPackage(){}
	
	@Pointcut("execution(* kali.dao.repository.*.*(..))")
	private void forDaoPackage(){}
	
	@Pointcut("forControllerPackage() || forDaoPackage()")
	private void MyAppFlow(){}
	
	@Before("MyAppFlow()")
	public void before(JoinPoint jp){
		String theMethod = jp.getSignature().toShortString();
		myLogger.info("--> in @Before: calling method: "+theMethod);
	}
}
