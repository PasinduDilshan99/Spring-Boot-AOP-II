package com.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Around("execution(* com.aop.service.*.*(..))")
    @Around("com.aop.config.PointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        logger.info("Around Aspect - Starts execute : {}", startTime);

        Object returnValue = joinPoint.proceed();
        logger.info("Around Aspect - Processing");

        long endTime = System.currentTimeMillis();
        logger.info("Around Aspect - End execute : {}", endTime);

        long executionDuration = endTime - startTime;

        logger.info("Around Aspect : {} - execution duration : {}", joinPoint, executionDuration);
        return returnValue;
    }
}
