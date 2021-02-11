package com.ibotta.gradle.aop.mixed;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class JavaAspect {

    private final CallerType callerType = CallerType.TARGET;

    @Before("execution(* demonstrateJavaAOP(..))")
    public void before(JoinPoint joinPoint) {
        MessageListener messageListener = (MessageListener) joinPoint.getArgs()[0];
        messageListener.onMessage("Java AOP before hook triggered.", CallerType.BEFORE_HOOK);
    }

    @After("execution(* demonstrateJavaAOP(..))")
    public void after(JoinPoint joinPoint) {
        Log.d("AOP logger", "AOP  has executed on the target method");
        MessageListener messageListener = (MessageListener) joinPoint.getArgs()[0];
        messageListener.onMessage("Java AOP after hook triggered.", CallerType.AFTER_HOOK);
    }
}
