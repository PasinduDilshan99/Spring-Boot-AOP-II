package com.aop.config;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutConfig {

    @Pointcut("execution(* com.aop.*.*.*(..))")
    public void serviceAndDataPackageConfig(){}

    @Pointcut("execution(* com.aop.service.*.*(..))")
    public void servicePackageConfig(){}

    @Pointcut("execution(* com.aop.repository.*.*(..))")
    public void dataPackageConfig(){}

    @Pointcut("bean(*Service*)")
    public void dataPackageConfigUsingBean(){}
}
