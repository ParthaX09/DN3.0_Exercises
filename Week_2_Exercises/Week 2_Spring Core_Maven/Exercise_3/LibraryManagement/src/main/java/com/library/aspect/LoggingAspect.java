package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class LoggingAspect {
    @Around("execution(* com.library.service.BookService.performService( ))")
   public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
    long startTime= System.currentTimeMillis();
    System.out.println("Execution starts at "+startTime+"ms");
    Object proceed=proceedingJoinPoint.proceed();
    long endTime=System.currentTimeMillis();
    System.out.println("Execution ends at "+endTime+"ms");
    long result=endTime-startTime;
    System.out.println("Execution took "+result+"ms");
    return proceed;
   }
}
