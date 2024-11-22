package com.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.aop.*.*.*(..))")
    public void beforeLogMethodCall(JoinPoint joinPoint){
        logger.info("Before Aspect - method is called : {} : .................... : {}", joinPoint, joinPoint.getArgs());
    }

    @After("execution(* com.aop.*.*.*(..))")
    public void afterLogMethodCall(JoinPoint joinPoint){
        logger.info("After Aspect - method is called : {}", joinPoint);
    }

    @AfterThrowing(pointcut = "execution(* com.aop.*.*.*(..))", throwing = "exception")
    public void afterThrowingLogMethodCall(JoinPoint joinPoint, Exception exception){
        logger.info("After Throwing Aspect - method is called : {}", joinPoint);
        logger.warn("After Throwing Aspect - Exception is : {}", exception.toString());
    }

    @AfterReturning(pointcut = "execution(* com.aop.*.*.*(..))" , returning = "returnValue")
    public void afterReturningLogMethodCall(JoinPoint joinPoint, Object returnValue){
        logger.info("After Returning Aspect - method is called : {}", joinPoint);
        logger.info("After Returning Aspect - Return value is : {}", returnValue.toString());
    }
}
