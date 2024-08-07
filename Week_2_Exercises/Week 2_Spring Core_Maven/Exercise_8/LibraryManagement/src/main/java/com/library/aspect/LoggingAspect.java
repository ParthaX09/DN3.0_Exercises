package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

import java.time.LocalDateTime;


@Aspect
public class LoggingAspect {
//    @Around("execution(* com.library.service.BookService.performService( ))")
//   public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//    long startTime= System.currentTimeMillis();
//    System.out.println("Execution starts at "+startTime+"ms");
//    Object proceed=proceedingJoinPoint.proceed();
//    long endTime=System.currentTimeMillis();
//    System.out.println("Execution ends at "+endTime+"ms");
//    long result=endTime-startTime;
//    System.out.println("Execution took "+result+"ms");
//    return proceed;
//   }
    @Before("execution(* com.library.service.BookService.performService())")
    public void beforeExecution(){
        System.out.println("Execution is Going to start");
        System.out.println("Starting the Logging process");
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("Execution started at "+localDateTime);
    }
    @After("execution(* com.library.service.BookService.performService())")
    public void afterExecution(){
        System.out.println("Execution is Going to end");
        System.out.println("Stopping the Logging process");
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("Execution ended at "+localDateTime);
    }
}
